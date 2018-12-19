package jiegouxing.proxy.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-16 上午 12:44
 */
public class Client {
    
    public static void main(String[] args) {
        
        Star star = new RealStar();
        StartHandler handler = new StartHandler(star);
        
        Star proxyInstance =
            (Star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, handler);
        
        proxyInstance.bookTicket();
        proxyInstance.collectMoney();
        proxyInstance.sing();
    }
}
