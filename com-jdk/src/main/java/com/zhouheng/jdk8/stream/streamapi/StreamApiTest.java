package com.zhouheng.jdk8.stream.streamapi;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {

//    public static void main(String[] args) {
//
//        List<String> list = Arrays.asList("aa","bbbb","ccc","ffff");
//
////        list.stream().forEach(System.out::println);
////
////        list.stream().sorted().forEach(System.out::println);
//
//        list.stream().sorted((e1,e2)-> e1.length()-e2.length()).forEach(System.out::println);
//
//        boolean b = list.stream().allMatch(e -> e instanceof String);
//        boolean b1 = list.stream().noneMatch(e -> e instanceof String);
//        Optional<String> first = list.stream().filter(e -> e.length() == 4).findFirst();
//        System.out.println(first.get());
//        System.out.println(b1);
//        System.out.println(b);
//
//        Set<String> collect = list.stream().collect(Collectors.toSet());
//
//        HashSet<String> collect1 = list.stream().collect(Collectors.toCollection(HashSet::new));
//
//        Double collect2 = list.stream().collect(Collectors.averagingDouble(r -> r.length()));
//        System.out.println(collect2);

//
//        Stream<Stream<Character>> streamStream = list.stream().map(e -> get(e));
//
//        streamStream.forEach(e ->e.forEach(System.out::println));
//
//        Stream<Character> characterStream = list.stream().flatMap(e -> get(e));
//        characterStream.forEach(System.out::println);
//    }

    static Stream<Character> get(String list){

        List<Character> list1 = new ArrayList<>();
        for (Character character : list.toCharArray()) {
          list1.add(character);
        }
        return list1.stream();
    }

    @Test
    public void test(){

        List<String> list = Arrays.asList("aa","bbbb","ccc","ffff");

        Double collect = list.stream().collect(Collectors.averagingDouble(e -> e.length()));

        Optional<Integer> max = list.stream().map(e -> e.length()).max(Integer::compare);

        Optional<String> max1 = list.stream().max((e1, e2) -> Integer.compare(e1.length(), e2.length()));

        Stream<String> parallel = list.stream().parallel();
        System.out.println(parallel);

        Stream<String> stringStream = list.parallelStream();
        System.out.println(stringStream);

        Stream<String> parallel1 = list.stream();
        System.out.println(parallel1);


    }
}
