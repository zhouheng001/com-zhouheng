package com.tujia.response;

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
@ApiModel
public class ResponseResult<T> {
    @ApiModelProperty("状态码")
    private int statusCode;
    @ApiModelProperty("提示信息")
    private String message;
    @ApiModelProperty("返回实体")
    private T t;

    public ResponseResult(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseResult(int statusCode, T t) {
        this.statusCode = statusCode;
        this.t = t;
    }
}
