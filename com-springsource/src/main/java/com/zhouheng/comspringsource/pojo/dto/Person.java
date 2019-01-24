package com.zhouheng.comspringsource.pojo.dto;

import lombok.Data;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:16
 */
@Data
public class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
