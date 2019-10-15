package com.tujia.com.dubbo.api.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhouheng-os
 * @Date 2019/10/15
 * @Description
 */
@Data
@AllArgsConstructor
@ApiModel("用户模型")
public class User {
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("用户名称")
    private String name;
    @ApiModelProperty("用户地址")
    private String address;
    @ApiModelProperty("用户Email")
    private String email;
}
