package com.foo;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zhouheng-os
 * @Date 2019/9/22
 * @Description
 *  定义商品信息的Service API
 */
public interface SkuInfoService {

    /**
     * 定义单线程处理任务的最大数量
     */
    int threadSize = 20;

    List<SkuInfoVO> getSkuInfoVoBySkuId(List<String> skuIds) throws InterruptedException;

}
