package chuangjianxing.siglenton;

/**
 * 描述:
 * 单例模式懒汉模式
 *
 * @author zhouheng
 * @create 2018-11-20 上午 1:09
 */
public class SinglentonLazy {
    //全局计数器
    SinglentonEnum singlentonEnum;

    //类初始化时,不加载这个对象
    private static SinglentonLazy singlenton;


    private SinglentonLazy(){

    }

    //方法同步调用效率低
    public static synchronized SinglentonLazy getSinglenton(){
        if(singlenton==null){
            singlenton = new SinglentonLazy();
        }
        return singlenton;
    }

    public SinglentonEnum getSinglentonEnum() {
        return singlentonEnum;
    }

    public void setSinglentonEnum(SinglentonEnum singlentonEnum) {
        this.singlentonEnum = singlentonEnum;
    }
}
