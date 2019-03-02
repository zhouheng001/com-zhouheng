package com.zhouheng.comspringsource.test;

import com.sun.xml.internal.ws.client.RequestContext;
import com.zhouheng.comspringsource.config.SpringConfigAutowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 16:27
 */

public class SpringTest01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigAutowired.class);
//        Car car = applicationContext.getBean(Car.class);
//        System.out.println(car);
//        Boss boss = applicationContext.getBean(Boss.class);
//        System.out.println(boss);
        RequestContext requestContext;

    }
}
