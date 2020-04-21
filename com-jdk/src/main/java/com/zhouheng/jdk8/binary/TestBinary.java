package com.zhouheng.jdk8.binary;

/**
 * @author heng.zhou
 * @description:
 * @create 2020-02-12 3:39 下午
 */
public class TestBinary {

    public static void main(String[] args) {
        // 二进制 0B开头表示二进制
        int a = 0B1111;
        // 默认十进制
        int b = 15;
        // 8进制 0开头表示8进制
        int c = 017;
        // 16进制 0X开头表示16进制
        int d = 0Xf;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
