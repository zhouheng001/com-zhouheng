package kv;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-02-18 上午 1:05
 */
public class TestKV {

    public static void main(String[] args) {
        String test = test(1, "有值", "输出");
        System.out.println(test);
        String test1 = test(1, null, "输出");
        System.out.println(test1);
        Integer integer = test1(123);
        System.out.println(integer);
    }

    public static  <K, V> V test(int a, K k, V v) {
        if (k != null) {
            System.out.println("有值!");
            return v;
        }
        System.out.println("无值!");
        return null;
    }

    public static  <K> K test2(K t){
        return t;
    }

    public static  <K,V,T,A,B,C,D> K test1(K t){
        return t;
    }

    public static  <T,V> boolean test2(Class<T> t,V v) throws IllegalAccessException, InstantiationException {
        if(v instanceof  Integer){
            return true;
        }
        return false;
    }

}
