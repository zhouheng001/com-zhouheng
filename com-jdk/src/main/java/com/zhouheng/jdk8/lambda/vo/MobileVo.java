package com.zhouheng.jdk8.lambda.vo;

import lombok.Data;

import java.util.Date;

/**
 * 描述: 手机基础信息
 *
 * @author zhouheng
 * @create 2018-11-13 上午 12:30
 */
@Data
public class MobileVo {

    private String mobileNumber;

    private String changShang;

    private Date date;

    private boolean success;

}
