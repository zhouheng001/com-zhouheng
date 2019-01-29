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

    public void init(){
        System.out.println("初始化:"+this.getClass());
        this.age=2;
        this.name="zhouheng";
    }

    /**
     * 只针对单实例bean起作用
     */
    public void destsory(){
        System.out.println("销毁");
    }

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
