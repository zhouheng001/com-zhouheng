package com.tujia.comjdk.interfacetest;

/**
 * Create by Administrator on 2019/6/10 0010
 */
public interface UserServiceImpl {

    static void test(){
        System.out.println(123);
    }

    default void teset1(String name){
        System.out.println(name);
    }
}
