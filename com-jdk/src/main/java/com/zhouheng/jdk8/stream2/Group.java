package com.zhouheng.jdk8.stream2;

import com.zhouheng.jdk8.isnull.param.Car;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 描述: 流分组处理
 *
 * @author zhouheng
 * @create 2018-11-07 上午 12:18
 */
public class Group {

    public static void main(String[] args) {

        Car m = new Car(12, "M");
        Car m1 = new Car(12, "W");
        Car m2 = new Car(13, "M");
        Car m3 = new Car(13, "W");
        Car m4 = new Car(14, "M");
        Car m5 = new Car(14, "W");

        List<Car> list = Arrays.asList(m,m1,m2,m3,m4,m5);
        System.out.println(list);
//
//        Map<String, ArrayList<Car>> collect = (Map<String, ArrayList<Car>>) list.stream().collect(Collectors.groupingBy(Car::getSex));
//        System.out.println(collect);

        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(Car::getAge, Car::getSex, (v1, v2) -> v2));
        Set<Map.Entry<Integer, String>> entries = collect.entrySet();
        entries.forEach(System.out::println);

        List<Object> objects = Collections.emptyList();

        IntConsumer aNew = String[]::new;


    }
}
