package chuangjianxing.siglenton;

/**
 * 描述:
 * 单例模式静态内部类实现
 *
 * @author zhouheng
 * @create 2018-11-21 上午 12:04
 */
public class SinglentonStaticInnerClass {

    private static class SinglentonInstanceClass {
        private static final SinglentonStaticInnerClass staticInnerClasss = new SinglentonStaticInnerClass();
    }

    private SinglentonStaticInnerClass() {
    }

    public static SinglentonStaticInnerClass getsinglenton() {
        return SinglentonInstanceClass.staticInnerClasss;
    }

}
