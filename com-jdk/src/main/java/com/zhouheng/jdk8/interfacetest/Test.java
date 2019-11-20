package com.zhouheng.jdk8.interfacetest;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-06-10 下午 2:54
 */
public class Test {

    public static final Integer a = null;

    public static void main(String[] args) {
        IUserService.test();
        IUserService userService = new UserServiceImpl();
        userService.teset1("zhou");


        System.out.println(IUserService.a);
    }
}
