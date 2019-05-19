package com.tujia.comjdk.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 下午 10:42
 */
public class MyCollections {
    public static void main(String[] args) {
//        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
//        for (int i = 0; i < 10; i++) {
//            copyOnWriteArrayList.add(i);
//        }
//        System.out.println(copyOnWriteArrayList.size());

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("abc");
        list.add("ab");
        list.add("ab");
        list.add("a");

        println(list);

        Map<Object, List<String>> collect = list.stream().collect(Collectors.groupingBy(l -> l));


    }

    public static void println(List<String> list) {
        HashMap hashMap = new HashMap<String,Integer>();
        TreeMap treeMap = new TreeMap<Integer,String>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (Object o : list) {
            if (hashMap.get(o) != null) {
                hashMap.put(o, (Integer) hashMap.get(o) + 1);
                continue;
            }
            hashMap.put(o, 1);
        }

        for (Object o : hashMap.keySet()) {
            treeMap.put(hashMap.get(o),o);
        }

        for (Object o : treeMap.keySet()) {
            System.out.println(treeMap.get(o)+":"+o);
        }


    }

}
