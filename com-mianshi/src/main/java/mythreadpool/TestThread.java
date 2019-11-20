package mythreadpool;

import sun.misc.Unsafe;

/**
 * @author zhouheng-os
 * @Date 2019/11/8
 * @Description
 */
public class TestThread {

    private static volatile int count;

    private static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {

        Unsafe.getUnsafe().storeFence();


        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o){
                        count++;
                    }
                }
            });

            thread.start();
        }
        System.out.println(count);
    }
}
