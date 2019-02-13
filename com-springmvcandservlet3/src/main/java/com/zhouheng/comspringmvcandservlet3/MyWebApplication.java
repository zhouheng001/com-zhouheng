package com.zhouheng.comspringmvcandservlet3;

import com.zhouheng.comspringmvcandservlet3.config.SpringConfig;
import com.zhouheng.comspringmvcandservlet3.config.SpringMvcConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-02-13 14:45
 */
public class MyWebApplication extends AbstractAnnotationConfigDispatcherServletInitializer {


    //相当于配置文件的spring监听器,创建spring容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringConfig.class};
    }

    //相当于配置文件的前端控制器,创建springmvc
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringMvcConfig.class};
    }

    //请求映射路径
    //  /：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
    //  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
