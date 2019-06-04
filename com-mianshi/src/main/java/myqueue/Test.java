package myqueue;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 14:33
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        MyQueue myQueue = new MyQueue(5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myQueue.addQueue(finalI);
                }
            }).start();
        }
        System.out.println(myQueue.getSize());
//        Thread.sleep(3000);
        System.out.println("!----------------");


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Object o = myQueue.removeQueue();
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
