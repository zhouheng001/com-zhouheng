package lock;

import java.util.concurrent.Callable;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-02 下午 3:40
 */
public class MyThreadLocal {

    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal<Object>(){
            @Override
            protected Object initialValue() {
                return super.initialValue();
            }
        };

       StringBuilder s = new StringBuilder("");

//        Person person = new Person(){
//            @Override
//            public void setName(String name) {
//                super.setName(name+"重写set");
//            }
//        };
//        person.setName("123");
//        System.out.println(person.getName());
//
//        for (int i=0;i<100;i++) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                  threadLocal.set(Thread.currentThread().getId());
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("-----线程-----"+threadLocal.get());
//                }
//            });
//            t.start();
//        }


        Runnable runnable = new Runnable() {

            int i = 100;

            @Override
            public void run() {
                while (true){
                    synchronized (this){
                        if(i==0){
                            System.out.println("票已售完!"+Thread.currentThread().getName());
                            return;
                        }
                        i--;
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("售票员:"+Thread.currentThread().getName()+"库存票数:"+i);
                    }
                }
            }
        };

        Callable callable = new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                return null;
            }

        };

        try {
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Thread t1 = new Thread(runnable, "A");
        Thread t2 = new Thread(runnable, "B");
        Thread t3 = new Thread(runnable, "C");

        t1.start();
        t2.start();
        t3.start();

    }

}
