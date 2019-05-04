package com.tujia.comjdk.isnull.param;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 上午 12:26
 */
public class Test {
    public static void main(String[] args) {
//        RequestParam<Car, Person> r = new RequestParam();
//        Car t1 = r.getT1();
//        System.out.println(t1);
//        System.out.println(t1 == null ? "null值" : t1.getPrice());
//        System.out.println(t1 != null && t1.getNum() != null ? t1.getNum() : "null值");

//        Person p = null;
//        System.out.println(test01(p));

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return 1;
            }
        };

        FutureTask future = new FutureTask(callable);
        new Thread(future).start();


        try {

            Object o = future.get();
            System.out.println("o："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean test01(Person p){
        Optional<Person> p1 = Optional.ofNullable(p);
//        Optional<Person> p2 = Optional.of(p);
        Person person = p1.get();
        System.out.println(person);
        return p1.isPresent();
    }
}
