package com.zhouheng.comspringsource.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-30 17:10
 */
@Component
public class CreateListener {

    @EventListener(classes = {ApplicationEvent.class})
    public void createListener(ApplicationEvent event){
        System.out.println("自定义的监听器,监听到的事件是："+ event);
    }
}
