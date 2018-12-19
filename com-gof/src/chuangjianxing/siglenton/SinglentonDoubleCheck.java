package chuangjianxing.siglenton;

/**
 * 描述:
 * 单例模式双重锁
 *
 * @author zhouheng
 * @create 2018-11-20 上午 1:15
 */
public class SinglentonDoubleCheck {

    private static SinglentonDoubleCheck singlentonDoubleCheck;

    private SinglentonDoubleCheck(){

    }

    public static SinglentonDoubleCheck getSingleton(){
        if(singlentonDoubleCheck==null){
            synchronized (SinglentonDoubleCheck.class){
                if(singlentonDoubleCheck==null){
                    singlentonDoubleCheck = new SinglentonDoubleCheck();
                }
            }
        }
        return singlentonDoubleCheck;
    }

}
