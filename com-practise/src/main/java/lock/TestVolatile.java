package lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-22 上午 2:14
 */
public class TestVolatile implements Runnable{

//    private volatile Integer count = 10;
    private AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        TestVolatile testVolatile = new TestVolatile();

        for (int i = 0; i <1000 ; i++) {
            new Thread(testVolatile).start();
        }
        Thread.sleep(3000);
        System.out.println(testVolatile.count);
    }

    @Override
    public void run() {
        count.incrementAndGet();
    }
}
