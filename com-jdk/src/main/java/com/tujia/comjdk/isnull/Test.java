package com.tujia.comjdk.isnull;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-19 下午 9:17
 */
public class Test implements ITest {
    public static void main(String[] args) {
        new Test().main1(null);
    }

    @Override
    public void main1(String[] args) {
        System.out.println("123");
    }

    @Override
    public void main2(String[] args) {

        System.out.println("123");
    }
}
