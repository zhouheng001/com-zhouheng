package jiegouxing.proxy.dynamicproxy.spring;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-21 14:20
 */
public class Client {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        SpringHandler springHandler = new SpringHandler();
        RealStar realStar1 = springHandler.getRealStar(realStar);
        realStar1.sing();
    }
}
