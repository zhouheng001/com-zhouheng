package jiegouxing.proxy.staticproxy;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-02 下午 11:44
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void bookTicket() {
        System.out.println("代理订票");
    }

    @Override
    public void collectMoney() {
        System.out.println("代理收钱");
    }

    @Override
    public void sing() {
        star.sing();
    }
}
