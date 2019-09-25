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

        ExecutorsUtils.invokeAll(skuInfoDTOS,skuIds,threadNum,threadSize,(List<String> nowskuIdList)->serviceBean.findByIds(nowskuIdList));

        return skuInfoDTOS.stream()
                .filter(skuInfoDTO -> skuInfoDTO.getSkuType().equals("ORIGIN") || skuInfoDTO.getSkuType().equals("DIGITAL"))
                .map(skuInfoDTO -> {
                            //根据商品类型进行分组聚合
                            if (skuInfoDTO.getSkuType().equals("ORIGIN")) {
                                return new SkuInfoVO(skuInfoDTO.getName(), skuInfoDTO.getArtNo(), "", getInventory(skuInfoDTO.getId()));
                            } else {
                                return new SkuInfoVO(skuInfoDTO.getName(), "", skuInfoDTO.getSpuId(), getInventory(skuInfoDTO.getId()));
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
