package jiegouxing.proxy.staticproxy;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-02 下午 11:46
 */
public class Client {
    public static void main(String[] args) {
        Star star = new RealStar();
        Star star1 = new ProxyStar(star);
        star1.bookTicket();
        star1.collectMoney();
        star1.sing();
    }
}
