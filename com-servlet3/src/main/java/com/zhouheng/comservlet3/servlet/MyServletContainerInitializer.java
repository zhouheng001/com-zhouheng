package com.zhouheng.comservlet3.servlet;

import com.zhouheng.comservlet3.compont.filter.MyFilter;
import com.zhouheng.comservlet3.compont.listener.MyListener;
import com.zhouheng.comservlet3.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-31 14:08
 */
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("感兴趣的类：");
        for (Class<?> aClass : c) {
            System.out.println("加载的类名:" + aClass.getSimpleName());
        }

        //通过配置类添加组件

        //添加servlet
        ServletRegistration.Dynamic dynamic = ctx.addServlet("myservlet", MyServlet.class);
        dynamic.addMapping("/zhouheng");
        //添加监听器
        ctx.addListener(MyListener.class);
        //添加过滤器
        FilterRegistration.Dynamic filter = ctx.addFilter("myfilter", MyFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

    }
}
