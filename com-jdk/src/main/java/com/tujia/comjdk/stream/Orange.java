package com.tujia.comjdk.stream;

import javax.annotation.PostConstruct;

/**
 * 描述: 橘子
 *
 * @author zhouheng
 * @create 2018-10-28 下午 10:08
 */
public class Orange<T> {

    int a;

    T t;

    @PostConstruct
    void init() {

        System.out.println("橘子");

    }

    public Orange() {
        System.out.println("构造");
    }

    @Override
    public String toString() {
        return "Orange{" + "a=" + a + ", t=" + t + '}';
    }
}
