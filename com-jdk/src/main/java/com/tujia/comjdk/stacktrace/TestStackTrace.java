package com.tujia.comjdk.stacktrace;

import com.tujia.comjdk.staticjdk.Person;

/**
 * 描述:
 * 通过堆内存来找对象
 *
 * @author zhouheng
 * @create 2019-07-24 17:30
 */
public class TestStackTrace {

    public static void main(String[] args) {

        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        Person person =new Person();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement);
        }
    }

}