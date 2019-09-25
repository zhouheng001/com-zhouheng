package com.foo.utils;

import com.foo.SkuInfoDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @author zhouheng-os
 * @Date 2019/9/22
 * @Description 定义线程工具类
 */
@Slf4j
public class ExecutorsUtils {

    /**
     * 获取线程池
     *
     * @param size
     * @return
     */
    public static ExecutorService getThreadPool(int size) {
        return Executors.newFixedThreadPool(size);
    }

    /**
     * 多任务执行工具类
     *
     * @param items
     * @param skuIds
     * @param function
     */
    public static <T,R> void invokeAll(List<R> items, List<T> skuIds, int threadNum, int threadSize, Function<List<T>, List<R>> function) throws InterruptedException {

        ExecutorService executorService = getThreadPool(threadNum);
        List<Callable<List<R>>> cList = new ArrayList<>();
        List<T> skuIdList = null;

        //多线程获取sku 基本信息
        for (int i = 0; i < threadNum; i++) {

            skuIdList = i == threadNum - 1 ? skuIds.subList(i * threadSize, skuIds.size()) : skuIds.subList(i * threadSize, (i + 1) * threadSize);

            final List<T> nowskuIdList = skuIdList;
            cList.add(() -> {
                List<R> skuInfoDTOList = null;
                try {
                    skuInfoDTOList = function.apply(nowskuIdList);
                } catch (Exception e) {
                    log.error("查询信息失败,异常信息{}", e.getMessage());
                    throw new Exception("查询信息失败是：" + nowskuIdList);
                }
                return skuInfoDTOList;
            });
        }

        //执行任务
        List<Future<List<R>>> results = executorService.invokeAll(cList);

        results.stream().forEach(result -> {
            try {
                items.addAll(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                log.error("部分产品信息返回有误,{}" + e.getMessage());
            }
        });
        executorService.shutdown();
    }
}
