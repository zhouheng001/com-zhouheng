package com.zhouheng.jdk8.lambda.test;

import com.zhouheng.jdk8.lambda.vo.A;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-15 上午 12:39
 */
public class Test2 {

    public static void main(String[] args) {

        A a = new A();
        a.setA(3);
        A a1 = new A();
        a1.setA(3);

        if (a.equals(a1)) {
            System.out.println("重写equal");
        }

        A b = new A();
        System.out.println(b.getA());

        Runnable runnable = () -> System.out.println("123");
        runnable.run();

        DoubleSupplier doubleSupplier = () -> {
            return 123;
        };
        double asDouble = doubleSupplier.getAsDouble();
        System.out.println(asDouble);

        IntBinaryOperator intBinaryOperator = (int g, int f) -> {
            return g + f;
        };

        int i = intBinaryOperator.applyAsInt(10, 20);
        System.out.println(i);

        Function<HashMap, Object> hashMapObjectFunction = (HashMap hashmap) -> {
            return hashmap.entrySet();
        };

        HashMap hashMap = new HashMap();
        Set<Map.Entry> set = hashMap.entrySet();

    }
}
