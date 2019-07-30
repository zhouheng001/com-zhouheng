package com.tujia.com.jdk8.staticjdk;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-16 下午 9:42
 */
public class Person implements Animal{

    private static int a;

    public void setA(int a){
        this.a = a;
    }

    public static int get(){
        return a;
    }

}
