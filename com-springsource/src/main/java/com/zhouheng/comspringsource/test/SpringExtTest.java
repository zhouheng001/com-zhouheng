package com.zhouheng.comspringsource.test;

import com.zhouheng.comspringsource.ext.SpringExtConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-30 11:23
 */
public class SpringExtTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringExtConfig.class);

        applicationContext.publishEvent(new ApplicationEvent("这是要发布的事件!") {
        });

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

}
