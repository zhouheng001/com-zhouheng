package com.zhouheng.jdk8.interfacetest;

/**
 * Create by Administrator on 2019/6/10 0010
 */
public  interface IUserService {

    static void test(){
        System.out.println(123);
    }

    default void teset1(String name){
        System.out.println(name);
    }

    int a = 0;

}
