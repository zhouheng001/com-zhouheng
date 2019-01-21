package com.tujia.comjdk.stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述: JDK的Stream介绍
 *
 * @author zhouheng
 * @create 2018-10-26 下午 10:38
 */
public class Test {

    private static T1 t;

    public static void main(String[] args)
            throws IOException {

        // List<String> s1 = Arrays.asList("1", "2", "3","4", "4", "5","6", "7");
        //
        // List<String> sss = new ArrayList<>();
        //
        // DirectoryStream.Filter<String> stringFilter = (String s) -> sss.add(s);
        // stringFilter.accept("123");
        //
        // List<Boolean> collect = s1.stream().distinct().map(s -> sss.add(s)).collect(Collectors.toList());
        //
        // sss.forEach(System.out::println);

        List<T1> s2 = Arrays.asList(new T1(
                2), new T1(1), new T1(11), new T1(1), new T1(1), new T1(5), new T1(5), new T1(7), new T1(14));

        // List<T1> collect1 = s2.stream().distinct().collect(Collectors.toList());
        // System.out.println(collect1);

        // Map<Integer, List<T1>> collect = s2.stream().distinct().collect(Collectors.groupingBy(T1::getA));

        // Map<Integer, List<T1>> collect = s2.stream().collect(Collectors.groupingBy(T1::getA));
        // System.out.println(collect);

        /**
         * 先把重复的属性提出来
         */
        List<Integer> collect = s2.stream().map(s -> s.getA()).distinct().collect(Collectors.toList());
        /**
         * 根据属性向原来的list赋值
         */
        List<T1> collect1 =
                collect.stream().map(ss -> s2.stream().filter(sss -> sss.getA() == ss).findFirst().get()).collect(
                        Collectors.toList());
        System.out.println(collect1);

        // Integer collect2 = collect1.stream().collect(Collectors.summingInt(T1::getA));
        // System.out.println(collect2);
        //
        // Double collect3 = collect1.stream().collect(Collectors.averagingInt(T1::getA));
        // System.out.println(collect3);
        //
        // IntSummaryStatistics collect4 = collect1.stream().collect(Collectors.summarizingInt(T1::getA));
        // System.out.println(collect4);

        String collect2 = collect1.stream().map(ss -> String.valueOf(ss.getA())).collect(Collectors.joining(","));
        System.out.println(collect2);

        // Optional<Integer> min = s2.stream().map(ss -> ss.getA()).min(Integer::max);
        // System.out.println(min.get());
        //
        // List<T1> collect = s2.stream().filter(ss -> ss.getA() == min.get()).collect(Collectors.toList());
        // System.out.println(collect);

        // int count = (int) s1.stream().filter(ss -> s2.contains(ss)).count();
        //
        //
        //
        // List<T1> sort = sort(s1, s2);

        // sort.forEach(System.out::println);

        // Stream<String> limit = s1.stream().skip(2).limit(2);
        //
        // limit.forEach(System.out::println);

        // List<T1> collect = s2.stream().sorted(Comparator.comparing((T1::getA))).collect(Collectors.toList());
        //
        // List<T1> collect2 = s2.stream().sorted((T1 t, T1 t1) -> t.getA() - t1.getA()).collect(Collectors.toList());
        //
        // Comparator<T1> t1Comparator = (T1 t, T1 t1) -> t.getA() - t1.getA();
        //
        // List<T1> collect1 = s2.stream().sorted((T1 t, T1 t1) ->
        // t1Comparator.compare(t,t1)*-1).collect(Collectors.toList());
        //
        //
        // collect1.forEach(System.out::println);

        // int a = new T1(3).a;
    }

    private static List<T1> sort(List<String> arg0, List<T1> t) {

        List<T1> s1 = new ArrayList<>();

        arg0.stream().forEach(ss -> {
            t.stream().filter(s3 -> ss.equals(String.valueOf(s3.getA()))).map(sss -> s1.add(sss)).collect(
                    Collectors.toList());
        });

        return s1;
    }

    private static void bian(int a, int b) {
        b = 3 + a;
    }

    private static void bian(T1 t, T1 t1) {
        t1.setA(t.getA());
    }

    private static void bian(List<String> t1) {

        t1 = Arrays.asList("1", "", "bc");

    }

}

class T1 implements Comparable<T1> {
    int a;

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "T1{" + "a=" + a + '}';
    }

    public T1(int a) {
        this.a = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public int compareTo(T1 o) {

        return 0;

    }
}