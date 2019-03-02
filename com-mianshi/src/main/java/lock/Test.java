package lock;

import java.util.concurrent.Callable;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-02-28 下午 12:07
 */
public class Test {
    public static void main(String[] args) throws Exception {

//        Callable<String> callable = callable("123");
//        String call = callable.call();
//        System.out.println(call);
        MyCallable<String> myCallable = new MyCallable<>();
        myCallable.call();

    }

    public static <V> Callable<V> callable(V v) throws Exception {
        Callable<V> callable = new Callable<V>() {
            @Override
            public V call() throws Exception {
                Thread.sleep(3000);
                return v;
            }
        };
        System.out.println("主线程!");
        return callable;
    }

    public static class MyCallable<V> implements Callable<V>{

        private String name;

        public MyCallable(){
            this.name="123";
        }

        @Override
        public V call() throws Exception {
            System.out.println(name);
            return (V) "";
        }
    }

}
