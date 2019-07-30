package com.tujia.com.jdk8.collection;

import java.util.*;

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

    }

    public static void println(List<String> list) {
        HashMap hashMap = new HashMap<String, Integer>();

        for (Object o : list) {
            if (hashMap.get(o) != null) {
                hashMap.put(o, (Integer) hashMap.get(o) + 1);
                continue;
            }
            hashMap.put(o, 1);
        }

        HashMap hashMap1 = hashMapSort(hashMap);
        for (Object o : hashMap1.keySet()) {
            System.out.println(o + ":" + hashMap1.get(o));
        }

    }

    public static HashMap<String, Integer> hashMapSort(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> keyList = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(keyList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });


        //3、将LinkedList按照排序好的结果，存入到HashMap中
        HashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : keyList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
