package com.tujia.comjdk.lambda;

import java.util.function.DoubleSupplier;

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
        
    }
}
