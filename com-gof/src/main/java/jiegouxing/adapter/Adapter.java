package jiegouxing.adapter;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-02 下午 10:25
 */
public class Adapter extends Adaptee implements Target {


    @Override
    public void handleRequest() {
        super.request();
    }
}
