package com.tujia.com.jdk8.stream;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-21 上午 12:15
 */
public class FanShe {

    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> a = Orange.class;
        Object o = FanShe1(a);
        System.out.println(o);
    }

    private static <T> T FanShe(T t) {
        return t;
    }

    private static Object FanShe1(Class<?> tClass) {
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
