package com.zhouheng.comspringsource.pojo.dto;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @author zhouheng
 * @Description:
 *   xxxxAware的功能 - - -> xxxxProcessor
 * @create 2019-01-24 16:14
 */
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext -->"+applicationContext);
        this.applicationContext=applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字："+name);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("你好${os.name}，我是#{20*16}");
        System.out.println("解析的字符串:"+s);
    }
}
