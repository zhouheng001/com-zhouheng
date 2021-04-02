package com.zhouheng.jdk13.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述:
 *  jdk13新特性
 * @author zhouheng
 * @create 2019-11-15 17:32
 */
public class TestString {

    public static void main(String[] args) {

        People p1 = new People(1,"zhouheng","fjasdfkj");
        People p2 = new People(1,"zhouheng","fjasdfkj");
        People p3 = new People(1,"jack","fjasdfkj");
        People p4 = new People(1,"jack","fjasdfkj");
        People p5 = new People(2,"zhouheng","fjasdfkj");
        People p6 = new People(2,"zhouheng","fjasdfkj");
        People p7 = new People(3,"zhouheng","fjasdfkj");
        List<People> list = new ArrayList<>();
        list.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));

//        Map<String, List<People>> collect = list.stream().collect(Collectors.groupingBy(d -> {
//            return d.getName();
//        }));
//        collect.forEach((k,v) -> System.out.println(v));
//        String s = list.stream().filter(l -> l.getName().equals("zhouheng")).map(l -> l.getValue()).findFirst().orElse("123");
//        System.out.println(s);
//
//        List<String> list1 = new ArrayList<>();
//        list1.add("123");
//        list1.add("1234");
//        list1.add("12345");
//        list1.add("123");
//        list1.add("1234");
//        list1.add("12345");
//        String[] strings = list1.toArray(new String[0]);
//        System.out.println(strings.length);

        People people = list.stream().max((e1, e2) -> Integer.compare(e1.getType(), e2.getType())).get();
        System.out.println(people);

        String str="Hello World";  //待判断的字符串
        String str1="llo World";  //待判断的字符串
        String str2="Hell";  //待判断的字符串
        String reg=".*ll.*";  //判断字符串中是否含有ll
        System.out.println(str.matches(reg));
        System.out.println(str1.matches(reg));
        System.out.println(str2.matches(reg));
    }
}