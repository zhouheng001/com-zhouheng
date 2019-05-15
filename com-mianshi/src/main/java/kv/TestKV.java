package kv;

import kv.hash.MyHashTable;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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

//        String property = System.getProperty("java.version");
//        Properties properties = System.getProperties();
//        System.out.println(property);

//        int Id =2;
//        int i = Id ^ (Id >>> 2);
//        System.out.println(i);
//        System.out.println(2^3);
//        System.out.println(4>>>32);
//
//        Hashtable<String,String> map = new Hashtable<>();
//        String put = map.put("a", "fadsa");
//        map.put("b","123");
//        map.put("c","dasd");
//        String put1 = map.put("a", "fsdfadfsfa");
//        System.out.println(put);
//        System.out.println(put1);
//        System.out.println(map.get("a"));
//        HashMap hashMap = new HashMap(4);
//        hashMap.put(null,null);
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put("","");
//
//        Map<String, String> stringStringMap = Collections.synchronizedMap(map);

        Hashtable hashTable = new MyHashTable();
        hashTable.put("1","zhouheng");
        System.out.println("put1成功!");
        Object o = hashTable.get("1");
        System.out.println(o);
        hashTable.put("2","zhouheng");
        System.out.println("put2成功!");

        BlockingQueue blockingDeque = new ArrayBlockingQueue(10);

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
