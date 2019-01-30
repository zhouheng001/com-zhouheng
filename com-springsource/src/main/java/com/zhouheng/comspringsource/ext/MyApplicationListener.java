package com.zhouheng.comspringsource.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-30 16:17
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent>{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("这是要监听的事件："+ event);
    }
}
