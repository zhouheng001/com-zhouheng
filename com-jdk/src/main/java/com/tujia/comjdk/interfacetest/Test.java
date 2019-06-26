package com.tujia.comjdk.interfacetest;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-06-10 下午 2:54
 */
public class Test {
    public static void main(String[] args) {
        UserServiceImpl.test();
        UserServiceImpl userService = new UserService();
        userService.teset1("zhou");
    }
}
