package com.tujia.com.jdk8.stream;

import com.tujia.com.jdk8.lambda.vo.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述: 11
 *
 * @author zhouheng
 * @create 2018-10-28 下午 11:38
 */
public class Test111 {

    public static void main(String[] args) {

        List<String> s1 = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            int i1 = new Random().nextInt(1000);
            s1.add(String.valueOf(i1));
        }
//
//        boolean b = s1.stream().allMatch(s -> s.length() == 1);
//
//        boolean b1 = s1.stream().anyMatch(s -> s.length() != 1);
//
//        boolean b2 = s1.stream().noneMatch(s -> s.length() == 1);
//
//        Optional<String> any = s1.stream().filter(s -> Integer.parseInt(s) > 3).findAny();
//
//        System.out.println(any.isPresent());
//        any.ifPresent(System.out::println);
//
//        String s2 = any.orElse("123");
//        System.out.println(s2);
//
        Integer sum = 0;

        long l1 = System.currentTimeMillis();
        List<Integer> collect1 = s1.parallelStream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - l1);

//        long l = System.currentTimeMillis();
//        List<Integer> collect = s1.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
//        System.out.println(System.currentTimeMillis()-l);


//        for (Integer s : collect) {
//            sum = s + sum;
//        }
//        System.out.println(sum);

//        Integer reduce = s1.stream().map(s -> Integer.parseInt(s)).reduce(0, Integer::sum);
//        System.out.println(reduce);
//
//        Optional<Integer> reduce1 = s1.stream().map(s -> Integer.parseInt(s)).reduce(Integer::max);
//        reduce1.ifPresent(System.out::println);
        //Collection系统集合中提供的流
        List<String> str = new ArrayList<>();
        Stream<String> stream = str.stream();
        //Arrays中的静态方法stream()获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //通过Stream中的of方法
       Stream<String> aa = Stream.of("aa", "bb", "cc");
        Object[] objects = aa.toArray();


        //创建无限流
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        iterate.skip(20).limit(10).forEach(System.out::println);
    }

}
