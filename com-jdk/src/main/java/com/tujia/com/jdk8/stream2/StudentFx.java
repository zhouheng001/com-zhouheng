package com.tujia.com.jdk8.stream2;/**
 * Create by Administrator on 2018/11/21 0021
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentFx extends Application {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(123, "周恒");
        map.put(123, "周恒1");
        System.out.println(map);
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}

class MyEntry<K, V> {

    int hash;

    K key;

    V value;

    MyEntry<K, V> myEntry;

    public MyEntry() {
    }

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MyEntry(int hash, K key, V value, MyEntry<K, V> myEntry) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.myEntry = myEntry;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
