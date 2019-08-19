package exception;

import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;

public class Test {

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static void main(String[] args) throws InterruptedException {
        int a = -2;
        System.out.println(a >> 1);
        CountDownLatch latch = new CountDownLatch(2);

        latch.countDown();


        latch.await();
    }
}
