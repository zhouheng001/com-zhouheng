package com.tujia.com.dubbo.api.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.tujia.response.ResponseResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
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
    @NotBlank(message = "用户ID不能为空")
    private String userId;
    @ApiModelProperty("用户名称")
    @NotBlank(message = "用户名不能为空")
    private String name;
    @ApiModelProperty("用户地址")
    @NotBlank(message = "用户地址不能为空")
    private String address;
    @ApiModelProperty("用户Email")
    @Email(message = "邮箱格式错误")
    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd  HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    @ApiModelProperty("用户地址")
    @Min(value = 18, message = "年龄不能小于18岁")
    private int year;
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式错误")
    private String phoneNum;

    public static void main(String[] args) {
        log.info("这是一个 -> {}","ceshi");
        ResponseResult<Object> build = ResponseResult.builder().message("123").build();
    }
}

