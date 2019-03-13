package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-12 下午 7:33
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();

        Object o = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                  synchronized (o){
                      System.out.println(1);
                      try {
                          o.notifyAll();
                          o.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (o){
                        System.out.println("a");
                        try {
                            o.notifyAll();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread.start();
        thread1.start();

    }

}
