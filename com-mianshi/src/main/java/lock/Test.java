package lock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
//        MyCallable<String> myCallable = new MyCallable<>();
//        myCallable.call();
//        ArrayBlockingQueue
        Lock myLock = new ReentrantLock();
        Condition condition1 = myLock.newCondition();
        Condition condition2 = myLock.newCondition();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myLock.lock();
                try {
                    condition2.signal();
                    System.out.println(1);
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    myLock.unlock();
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myLock.lock();
                try {
                    condition1.signal();
                    System.out.println(2);
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    myLock.unlock();
                }
            }
        });

        thread.start();
        thread1.start();

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

    public static class MyCallable<V> implements Callable<V> {

        private String name;

        public MyCallable() {
            this.name = "123";
        }

        @Override
        public V call() throws Exception {
            System.out.println(name);
            return (V) "";
        }
    }

}
