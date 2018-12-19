package chuangjianxing.siglenton;

import java.io.Serializable;

/**
 * 描述:
 *  测试反射和反序列化
 *
 * @author zhouheng
 * @create 2018-11-20 上午 1:09
 */
public class SinglentonLazyReflect implements Serializable{
    //全局计数器
    SinglentonEnum singlentonEnum;

    //类初始化时,不加载这个对象
    private static SinglentonLazyReflect singlenton;

    //防止反射创建对象
    private SinglentonLazyReflect(){
           if(singlenton==null){
               throw new RuntimeException();
           }
    }

    //方法同步调用效率低
    public static synchronized SinglentonLazyReflect getSinglenton(){
        if(singlenton==null){
            singlenton = new SinglentonLazyReflect();
        }
        return singlenton;
    }

    public SinglentonEnum getSinglentonEnum() {
        return singlentonEnum;
    }

    public void setSinglentonEnum(SinglentonEnum singlentonEnum) {
        this.singlentonEnum = singlentonEnum;
    }

    //反序列化直接调用这个方法
    private Object readResolve(){
        return singlenton;
    }
}
