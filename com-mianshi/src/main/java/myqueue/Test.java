package myqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 14:33
 */
public class Test {
    public static void main(String[] args) {

//        MyQueue myQueue = new MyQueue(5);
//        Object o = myQueue.removeQueue();

        Object o = new Object();
        o.notify();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();

        while (true){
            if(executorService.isTerminated()){
                System.out.println("执行结束!");
                break;
            }
        }

    }
}
