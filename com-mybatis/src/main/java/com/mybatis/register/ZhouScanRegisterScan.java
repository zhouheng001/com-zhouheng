package com.mybatis.register;

import com.mybatis.ZhouFactoryBean;
import com.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-20 下午 7:46
 */
public class ZhouScanRegisterScan implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        //配置扫描
        System.out.println("正在扫描");
        //把扫描出来的bd的beanClass改成FactoryBean
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserMapper.class);
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();

        genericBeanDefinition.setBeanClass(ZhouFactoryBean.class);
        registry.registerBeanDefinition("userMapper", genericBeanDefinition);
    }
}
