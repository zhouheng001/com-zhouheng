package jiegouxing.proxy.dynamicproxy.spring;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-02 下午 11:43
 */
public class RealStar {


    public void bookTicket() {
        System.out.println("自己订票");
    }

    public void collectMoney() {
        System.out.println("自己收钱");
    }

    public void sing() {
        System.out.println("自己唱歌");
    }
}
