package com.tujia.comjdk.isnull.param;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 上午 12:26
 */
public class Test {
    public static void main(String[] args) {
        RequestParam<Car, Person> r = new RequestParam();
        Car t1 = r.getT1();
        System.out.println(t1);
        System.out.println(t1 == null ? "null值" : t1.getPrice());
        System.out.println(t1 != null && t1.getNum() != null ? t1.getNum() : "null值");
    }
}
