package com.zhouheng.jdk13.test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2020-11-19 2:02 下午
 */
@Data
@AllArgsConstructor
public class People {

    private int type;

    private String name;

    private String value;


}