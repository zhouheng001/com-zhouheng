package chuangjianxing.siglenton;

/**
 * 描述:
 * 单例模式饿汉模式
 *
 * @author zhouheng
 * @create 2018-11-20 上午 12:58
 */
public class SingletonHungry {

    //类初始化时,立即加载
    private static final SingletonHungry singleton = new SingletonHungry();

    private SingletonHungry() {

    }

    //方法没有同步调用效率高
    public static SingletonHungry getSingleton() {
        return singleton;
    }

}
