package com.zhouheng.comspringsource.condition;

import com.zhouheng.comspringsource.pojo.dto.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 15:26
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry 注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean person = registry.containsBeanDefinition("person");
        BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class.getName());
        if(person){
            registry.registerBeanDefinition("rainbow",beanDefinition);
        }

    }
}
