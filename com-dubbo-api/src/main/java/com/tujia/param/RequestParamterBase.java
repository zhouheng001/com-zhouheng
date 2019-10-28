package com.tujia.param;

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
@ApiModel(value = "请求基础模型")
public class RequestParamterBase<T> {
    @ApiModelProperty("请求标识ID")
    private String requestId;
    @ApiModelProperty("请求实体")
    private T t;
}
