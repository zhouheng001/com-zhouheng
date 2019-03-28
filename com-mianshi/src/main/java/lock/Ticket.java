package lock;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-13 下午 9:50
 */
public class Ticket {

    private static int ticket =10;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    if(ticket==0){
                        try {
                            System.out.println("没票了"+Thread.currentThread());
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ticket--;
                    System.out.println(ticket+Thread.currentThread().getName());
                }
            }
        };

        for (int i = 0; i <20 ; i++) {
            Thread thread = new Thread(runnable, "t1");
            Thread thread1 = new Thread(runnable, "t2");
            thread.start();
            thread1.start();
        }
        System.out.println("123");
    }
}
