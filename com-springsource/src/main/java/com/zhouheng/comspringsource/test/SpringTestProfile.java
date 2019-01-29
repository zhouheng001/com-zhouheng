package com.zhouheng.comspringsource.test;

import com.zhouheng.comspringsource.config.SpringConfigProfile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-29 11:09
 */
public class SpringTestProfile {

    /**
     * 法一: 使用虚拟机启动命令选择环境 -Dspring.profiles.active=test
     * 法二: 通过代码配置
     * @param args
     */
    public static void main(String[] args) {

//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigProfile.class);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //选择Profile环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //注入配置类
        applicationContext.register(SpringConfigProfile.class);
        //刷新容器
        applicationContext.refresh();



        Map<String, DataSource> beansOfType = applicationContext.getBeansOfType(DataSource.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("数据源："+s);
        }

        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println(bean);

    }

}
