package com.foo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhouheng-os
 * @Date 2019/9/22
 * @Description 显示prd商品信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuInfoVO implements Serializable {

    private static final long serialVersionUID = -2550333263875720169L;
    /**
     * SKU 名称
     */
    private String name;
    /**
     * 货号
     */
    private String artNo;
    /**
     * itemid
     */
    private String spuId;
    /**
     * 库存数量, 保留小数点后2位
     */
    private BigDecimal inventory;
}
