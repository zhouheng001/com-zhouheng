package com.zhouheng.comspringsource.test;

import com.zhouheng.comspringsource.config.SpringConfigAutowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 16:27
 */

public class SpringTest01 implements Serializable{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigAutowired.class);
//        UserService bean = applicationContext.getBean(UserService.class);
//        bean.Test();
//        bean.insert();
//        Car car = applicationContext.getBean(Car.class);
//        System.out.println(car);
//        Boss boss = applicationContext.getBean(Boss.class);
//        System.out.println(boss);
    }
}
