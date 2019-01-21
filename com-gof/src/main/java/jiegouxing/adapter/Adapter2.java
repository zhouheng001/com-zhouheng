package jiegouxing.adapter;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-02 下午 10:25
 */
public class Adapter2 implements Target {

    private Adaptee adaptee;

    @Override
    public void handleRequest() {
        adaptee.request();
    }

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
