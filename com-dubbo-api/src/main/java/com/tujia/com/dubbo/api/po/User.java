package com.tujia.com.dubbo.api.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tujia.response.ResponseResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhouheng-os
 * @Date 2019/10/15
 * @Description
 */
@Data
@AllArgsConstructor
@ApiModel("用户模型")
@Slf4j
public class User {
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("用户名称")
    private String name;
    @ApiModelProperty("用户地址")
    private String address;
    @ApiModelProperty("用户Email")
    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd  HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    public static void main(String[] args) {
        log.info("这是一个 -> {}","ceshi");
        ResponseResult<Object> build = ResponseResult.builder().message("123").build();
    }
}
