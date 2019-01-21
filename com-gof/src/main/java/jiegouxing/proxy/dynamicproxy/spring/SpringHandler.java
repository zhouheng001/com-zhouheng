package jiegouxing.proxy.dynamicproxy.spring;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述:
 * Spring动态代理
 * @author zhouheng
 * @create 2019-01-21 14:05
 */
public class SpringHandler implements MethodInterceptor {


    public RealStar getRealStar(RealStar o1){
        //核心对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(o1.getClass());
        enhancer.setCallback(this);
        enhancer.setClassLoader(o1.getClass().getClassLoader());

        RealStar realStar = (RealStar) enhancer.create();
        return realStar;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object invoke = null;

        if(method.getName().equals("sing")){
            System.out.println("代理前!");
            invoke = methodProxy.invokeSuper(o, objects);
            System.out.println("代理后!");
        }

        return invoke;
    }
}
