package jiegouxing.proxy.dynamicproxy.jdk;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-02 下午 11:43
 */
public class RealStar implements Star {
    
    @Override
    public void bookTicket() {
        System.out.println("自己订票");
    }
    
    @Override
    public void collectMoney() {
        System.out.println("自己收钱");
    }
    
    @Override
    public void sing() {
        System.out.println("自己唱歌");
    }
}
