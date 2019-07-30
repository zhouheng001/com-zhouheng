package com.tujia.com.jdk8.staticjdk;

import java.util.HashMap;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-16 下午 9:45
 */
public class Test {

    private static HashMap hashMap;

    static {
        hashMap = new HashMap();
        hashMap.put(Person.class,new Person());

        for (Object o : hashMap.values()) {
            factory(o);
        }
    }

    public static void main(String[] args) {

        System.out.println(Person.get());

    }


    static <T> void factory(T t)  {

        if(t instanceof Animal){
            ((Animal) t).setA(10);
        }
    }

}
