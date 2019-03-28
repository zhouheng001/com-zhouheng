package com.tujia.comjdk.isnull;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-19 下午 9:17
 */
public class Test implements ITest {
    public static void main(String[] args) {
//        new Test().main1(null);
        List list = new ArrayList();
        for (int i = 0; i < 1000000000 ; i++) {
              list.add("dlkajflkdsjflkasdfj坚实的解放军安抚");
        }
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
