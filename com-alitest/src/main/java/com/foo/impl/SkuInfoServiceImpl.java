package com.foo.impl;

import com.foo.*;
import com.foo.utils.ExecutorsUtils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author zhouheng-os
 * @Date 2019/9/22
 * @Description
 */
@Slf4j
public class SkuInfoServiceImpl implements SkuInfoService {

    ServiceBeanFactory serviceBeanFactory = ServiceBeanFactory.getInstance();

    SkuService serviceBean = serviceBeanFactory.getServiceBean(SkuService.class);

    InventoryService inventoryService = serviceBeanFactory.getServiceBean(InventoryService.class);

    /**
     * 根据传入一组 skuIds 获取商品信息(入参限定不能超过100个)
     *
     * @param skuIds 不能超过100个
     * @return
     */
    @Override
    public List<SkuInfoVO> getSkuInfoVoBySkuId(List<String> skuIds) throws InterruptedException {
        if (skuIds.size() > 100) {
            throw new RuntimeException("不能超过100个 skuId");
        }

        List<SkuInfoDTO> skuInfoDTOS = new ArrayList<>();

        int remainder = skuIds.size() % threadSize;
        int threadNum;
        if (remainder == 0) {
            threadNum = skuIds.size() / threadSize;
        } else {
            threadNum = skuIds.size() / threadSize + 1;
        }

        ExecutorService executorService = ExecutorsUtils.getThreadPool(threadNum);

        List<Callable<List<SkuInfoDTO>>> cList = new ArrayList<>();
        Callable<List<SkuInfoDTO>> task = null;
        List<String> skuIdList = null;

        //多线程获取sku 基本信息
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                skuIdList = skuIds.subList(i * threadSize, skuIds.size());
            } else {
                skuIdList = skuIds.subList(i * threadSize, (i + 1) * threadSize);
            }

            final List<String> nowskuIdList = skuIdList;
            task = new Callable<List<SkuInfoDTO>>() {
                @Override
                public List<SkuInfoDTO> call() throws Exception {

                    List<SkuInfoDTO> skuInfoDTOList = null;
                    try {
                        skuInfoDTOList = serviceBean.findByIds(nowskuIdList);
                    } catch (Exception e) {
                        log.error("查询sku信息失败,失败的原因是{}", e.getMessage());
                        throw new Exception("查询sku信息失败的skuIds：" + nowskuIdList);
                    }
                    return skuInfoDTOList;
                }
            };
            cList.add(task);
        }

        //执行任务
        List<Future<List<SkuInfoDTO>>> results = executorService.invokeAll(cList);

        results.stream().forEach(result -> {
            try {
                skuInfoDTOS.addAll(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                log.error("部分产品信息返回有误,{}" + e.getMessage());
            }
        });
        executorService.shutdown();

        return skuInfoDTOS.stream()
                .map(skuInfoDTO -> {
                            //根据商品类型进行分组聚合
                            if (skuInfoDTO.getSkuType().equals("ORIGIN")) {
                                return new SkuInfoVO(skuInfoDTO.getName(), skuInfoDTO.getArtNo(), "", getInventory(skuInfoDTO.getId()));
                            } else if (skuInfoDTO.getSkuType().equals("DIGITAL")) {
                                return new SkuInfoVO(skuInfoDTO.getName(), "", skuInfoDTO.getSpuId(), getInventory(skuInfoDTO.getId()));
                            }else {
                                return new SkuInfoVO(skuInfoDTO.getName(), "","", getInventory(skuInfoDTO.getId()));
                            }
                        }
                )
                .collect(Collectors.toList());

    }

    /**
     * 根据skuId进行库存统计
     *
     * @param skuId
     * @return
     */
    private BigDecimal getInventory(String skuId) {
        List<ChannelInventoryDTO> channelInventoryDTOS = inventoryService.getBySkuId(skuId);
        return channelInventoryDTOS.stream().map(channelInventoryDTO -> channelInventoryDTO.getInventory()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

}
