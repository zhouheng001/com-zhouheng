package kv;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-02-18 上午 1:05
 */
public class TestKV {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
//        String test = test(1, "有值", "输出");
//        System.out.println(test);
//        String test1 = test(1, null, "输出");
//        System.out.println(test1);
//        Integer integer = test1(123);
//        System.out.println(integer);
//        String a = "123";
//        String c = "456";
//        System.out.println(a+c);
//        System.out.println("123"+"456"=="123456");
//        System.out.println(a+c=="123456");
//        HashMap hashMap= new HashMap();

//        Class<User> userClass = User.class;
//        User user = userClass.newInstance();
//        Method[] methods = userClass.getMethods();
//        for (Method method : methods) {
//            if (method.getName().equals("setA"))
//                method.invoke(user, 3);
//        }

//        StringBuilder a= new StringBuilder("123");
//        StringBuilder b = a;
//        b.append("ad");
//        System.out.println(a);
//        String c = new String("123");
//        System.out.println("123" == c);

        String property = System.getProperty("java.version");
        Properties properties = System.getProperties();
        System.out.println(property);

    }

    public static <K, V> V test(int a, K k, V v) {
        if (k != null) {
            System.out.println("有值!");
            return v;
        }
        System.out.println("无值!");
        return null;
    }

    public static <K> K test2(K t) {
        return t;
    }

    public static <K, V, T, A, B, C, D> K test1(K t) {
        return t;
    }

    public static <T, V> boolean test2(Class<T> t, V v) throws IllegalAccessException, InstantiationException {
        if (v instanceof Integer) {
            return true;
        }
        return false;
    }

}
