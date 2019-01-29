package com.zhouheng.comspringsource.config;

import com.zhouheng.comspringsource.aop.SpringTestAop;
import com.zhouheng.comspringsource.manager.JiSuanManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-29 11:59
 */
@EnableAspectJAutoProxy  //
@Configuration
public class SpringConfigAop {

    @Bean
    public JiSuanManager jiSuanManager(){
        return new JiSuanManager();
    }

    @Bean
    public SpringTestAop springTestAop(){
        return new SpringTestAop();
    }

}
