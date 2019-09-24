package com.foo.impl;

import com.foo.*;
import com.foo.utils.ExecutorsUtils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
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
        int threadNum = skuIds.size() % threadSize == 0 ? skuIds.size() / threadSize : skuIds.size() / threadSize + 1;


        ExecutorService executorService = ExecutorsUtils.getThreadPool(threadNum);

        List<Callable<List<SkuInfoDTO>>> cList = new ArrayList<>();
        List<String> skuIdList = null;

        //多线程获取sku 基本信息
        for (int i = 0; i < threadNum; i++) {

            skuIdList = i == threadNum - 1 ? skuIds.subList(i * threadSize, skuIds.size()) : skuIds.subList(i * threadSize, (i + 1) * threadSize);

            final List<String> nowskuIdList = skuIdList;
            cList.add(() -> {
                List<SkuInfoDTO> skuInfoDTOList = null;
                try {
                    skuInfoDTOList = serviceBean.findByIds(nowskuIdList);
                } catch (Exception e) {
                    log.error("查询sku信息失败,异常信息{}", e.getMessage());
                    throw new Exception("查询sku信息失败的skuIds：" + nowskuIdList);
                }
                return skuInfoDTOList;
            });
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
                .map(skuInfoDTO ->
                        //根据商品类型进行分组聚合
                        skuInfoDTO.getSkuType().equals("ORIGIN") ? new SkuInfoVO(skuInfoDTO.getName(), skuInfoDTO.getArtNo(), "", getInventory(skuInfoDTO.getId())) : new SkuInfoVO(skuInfoDTO.getName(), "", skuInfoDTO.getSpuId(), getInventory(skuInfoDTO.getId())))
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
