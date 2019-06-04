package myqueue;

import lombok.Data;

import java.util.LinkedList;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-15 14:17
 */
@Data
public class MyQueue {
    /**
     * 队列容器
     */
    private LinkedList list = new LinkedList();

    public MyQueue(LinkedList list, int size) {
        this.list = list;
        this.size = size;
    }

    public MyQueue() {
    }

    public MyQueue(int size) {
        this.size = size;
    }

    /**
     * 队列大小
     */
    private int size;

    public synchronized void addQueue(Object object) {

        try {
            /** 判断队列是否满了 */
            while (list.size() == this.size) {
                wait();
            }

            /** 队列中添加消息 */
            list.add(object);

            /** 当队列大小不为空是唤醒所有消费线程 */
            if (list.size() > 0) {
                notifyAll();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public synchronized Object removeQueue() {

        try {
            /** 判断队列是否里面是否消费完了 */
            while (list.size() == 0) {
                wait();
            }

            Object remove = list.remove();

            /** 当队列大小小于最大尺寸是,唤醒所有添加线程 */
            if (list.size() < this.size) {
                notifyAll();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list.remove();
    }

}
