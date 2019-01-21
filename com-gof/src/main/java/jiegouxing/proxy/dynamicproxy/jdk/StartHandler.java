package jiegouxing.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述: JDK动态代理， 处理器对象
 *
 * @author zhouheng
 * @create 2018-12-16 上午 12:31
 */
public class StartHandler implements InvocationHandler {

    Star realstar;

    public StartHandler(Star realstar) {
        super();
        this.realstar = realstar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        if (method.getName().equals("sing")) {
            System.out.println("方法执行前!");
            method.invoke(realstar, args);
            System.out.println("方法执行后!");
        }

        return null;
    }
}
