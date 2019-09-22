package com.foo;

import com.foo.impl.SkuInfoServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class ExamTest {

    private static List<String> skuIds;

    /**
     * 构造100个 skuid 作为测试条件
     */
    @BeforeClass
    public static void setUp() {
        skuIds = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            skuIds.add(String.valueOf(i));
        }
    }

    @AfterClass
    public static void tearDown() {
        skuIds = null;
    }

    @Test
    public void testService() throws ExecutionException, InterruptedException {

        ServiceBeanFactory instance = ServiceBeanFactory.getInstance();
        InventoryService serviceBean = instance.getServiceBean(InventoryService.class);
        for (String skuId : skuIds) {
            System.out.println(  serviceBean.getBySkuId(skuId)+" "+skuId);
        }

        SkuInfoService skuInfoService = new SkuInfoServiceImpl();
        List<SkuInfoVO> skuInfoVOS = skuInfoService.getSkuInfoVoBySkuId(skuIds);
        skuInfoVOS.forEach(skuInfoVO -> System.out.println(skuInfoVO));


    }

}
