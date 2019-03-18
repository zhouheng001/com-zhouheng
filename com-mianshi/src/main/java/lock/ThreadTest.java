package lock;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-12 下午 7:33
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {


        Object o = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                  synchronized (o){
                      System.out.println(1);
                      try {
                          o.notify();
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
                            o.notify();
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
