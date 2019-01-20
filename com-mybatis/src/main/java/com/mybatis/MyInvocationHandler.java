package com.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-20 下午 9:01
 */
public class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行sql");
        return null;
    }
}
