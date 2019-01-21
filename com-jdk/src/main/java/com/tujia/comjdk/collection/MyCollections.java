package com.tujia.comjdk.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 下午 10:42
 */
public class MyCollections {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add(i);
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
