package myqueue;

import lombok.Data;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 14:17
 */
@Data
public class MyBlockQueue {
    /**
     * 队列容器
     */
    private LinkedList list = new LinkedList();

    private ReentrantLock lock = new ReentrantLock();
    private Condition isNull = lock.newCondition();
    private Condition isFull = lock.newCondition();

    public MyBlockQueue(LinkedList list, int size) {
        this.list = list;
        this.size = size;
    }

    public MyBlockQueue() {
    }

    public MyBlockQueue(int size) {
        this.size = size;
    }

    /**
     * 队列大小
     */
    private int size;

    public  void addQueue(Object object) {

            try {
                lock.lock();
                /** 判断队列是否满了 */
                try {
                    while (list.size() == this.size) {
                        System.out.println("已经满5个了!");
                        isFull.await();
                    }
                }catch (Exception e){
                    isFull.signal();
                    System.out.println("异常信息"+e);
                }

                /** 队列中添加消息 */
                list.add(object);

                /** 当队列大小不为空是唤醒所有消费线程 */
                if (list.size() > 0) {
                    isNull.signal();
                }
            } catch (Exception e) {
                System.out.println("异常信息"+e);
            }finally {
                lock.unlock();
            }


    }

    public  Object removeQueue() {

            try {
                lock.lock();
                /** 判断队列是否里面是否消费完了 */
                try {
                    while (list.size() == 0) {
                        System.out.println("已经空了!");
                        isNull.await();
                    }
                }catch (Exception e){
                    isNull.signal();
                }

                /** 当队列大小小于最大尺寸是,唤醒所有添加线程 */
                if (list.size() < this.size) {
                    isFull.signal();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                lock.unlock();
            }


        return list.remove();
    }

}
