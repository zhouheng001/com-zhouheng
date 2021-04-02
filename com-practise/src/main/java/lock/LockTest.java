package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * 测试加锁过程
 *
 * @author zhouheng
 * @create 2021-01-25 9:41 上午
 */
public class LockTest {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        reentrantLock.tryLock();
        try {
            int a = 1/0;
        }finally {
            reentrantLock.unlock();
        }
    }

}
