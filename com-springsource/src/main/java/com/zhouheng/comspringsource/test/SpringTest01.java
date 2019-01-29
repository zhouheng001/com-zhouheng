package com.zhouheng.comspringsource.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zhouheng.comspringsource.config.SpringConfigAutowired;
import com.zhouheng.comspringsource.config.SpringConfigLifeCycle;
import com.zhouheng.comspringsource.pojo.dto.Boss;
import com.zhouheng.comspringsource.pojo.dto.Car;
import com.zhouheng.comspringsource.pojo.dto.Color;
import com.zhouheng.comspringsource.pojo.dto.Person;
import com.zhouheng.comspringsource.service.UserService;
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
    }
}
