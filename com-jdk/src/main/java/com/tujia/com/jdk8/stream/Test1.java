package com.tujia.com.jdk8.stream;

import java.util.List;
import java.util.function.*;

/**
 * 描述: Lambdas表达式函数
 *
 * @author zhouheng
 * @create 2018-10-26 下午 10:59
 */
public class Test1 {

    public static void main(String[] args) {

        // 布尔类型
        Predicate<Integer> b = (Integer a) -> a > 6;
        System.out.println(b.test(8));
        testt(4, b);

        // 创建对象
        Consumer<Integer> integerConsumer = (Integer a) -> new Integer(a);
        integerConsumer.accept(3);

        // 消费一个对象从另一个对象中
        Function<List, Integer> sss = (List s) -> s.size();
        ToIntFunction<List> listConsumer = (List ss) -> ss.size();

        // 比较两个对象
        BiFunction<String, String, Boolean> stringStringObjectBiFunction =
                (String s, String a) -> s.length() == a.length();
        Boolean apply = stringStringObjectBiFunction.apply("aa", "ss");

        Apple apple = new Apple() {

            @Override
            public void putApple() {

                System.out.println("jsdfdsjafklj");

            }
        };


        if (apple == null) {
            return;
        }

        Runnable aNew = Orange::new;
        Class<? extends Runnable> aClass = aNew.getClass();

    }

    static void testt(Integer a, Predicate<Integer> predicate) {

        System.out.println(predicate.test(a));
    }

    static class App {

    }

}
