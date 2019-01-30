package com.zhouheng.comspringsource.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-30 11:20
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.println("容器加载的bean的数量："+beanDefinitionCount);

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("容器加载的bean的名字：");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
