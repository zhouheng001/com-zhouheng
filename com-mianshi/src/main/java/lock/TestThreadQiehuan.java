package lock;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-22 上午 1:59
 */
public class TestThreadQiehuan {

    public static void main(String[] args) {

        Object o = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i=0;i<10;i++){
                        try {
                            System.out.println("t1");
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i=0;i<10;i++){
                        try {
                            System.out.println("t2");
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
