package myqueue;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 14:33
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        MyBlockQueue myBlockQueue = new MyBlockQueue(5);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                myBlockQueue.addQueue(i);
                System.out.println("塞入" + i);
            }
        });


        t1.start();
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    myBlockQueue.addQueue(finalI);
//                }
//            }).start();
//        }
        Thread.sleep(3000);
//        System.out.println("!----------------");


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Object o = myBlockQueue.removeQueue();
                    System.out.println(o);
                }
            }).start();
        }



//        Object o = new Object();
//        o.notify();
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        executorService.shutdown();
//
//        while (true){
//            if(executorService.isTerminated()){
//                System.out.println("执行结束!");
//                break;
//            }
//        }
//
//        BlockingQueue a = new ArrayBlockingQueue<>(10);
//
//        ExecutorService executorService = new ThreadPoolExecutor(5,10,30 , TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    }
}
