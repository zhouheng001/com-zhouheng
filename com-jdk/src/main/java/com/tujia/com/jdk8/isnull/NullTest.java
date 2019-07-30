package com.tujia.com.jdk8.isnull;

import java.text.SimpleDateFormat;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-19 下午 9:26
 */
public class NullTest implements ITest {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(l);
        System.out.println(format);
    }

    public void main1(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    public void main2(String[] args) {

    }
}
