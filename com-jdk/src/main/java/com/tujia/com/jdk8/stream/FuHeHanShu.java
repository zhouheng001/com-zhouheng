package com.tujia.com.jdk8.stream;

import java.util.function.Function;

/**
 * 描述: 复合函数
 *
 * @author zhouheng
 * @create 2018-10-28 下午 10:29
 */
public class FuHeHanShu {

    public static void main(String[] args) {

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Integer apply = f.apply(3);

        Integer apply1 = f.andThen(g).apply(3); // 先操作f，在操作g
        System.out.println(apply1);

        Integer apply2 = f.compose(g).apply(3); // 先操作g，在操作f
        System.out.println(apply2);

    }

}
