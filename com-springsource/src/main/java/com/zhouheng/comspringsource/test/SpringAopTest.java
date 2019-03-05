package com.zhouheng.comspringsource.test;

import com.zhouheng.comspringsource.config.SpringConfigAop;
import com.zhouheng.comspringsource.manager.JiSuanManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-29 14:09
 */
public class SpringAopTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigAop.class);
        JiSuanManager bean = applicationContext.getBean(JiSuanManager.class);
        System.out.println("输出结果:"+bean.calculator(1,0));
    }
}
