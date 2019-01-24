package com.zhouheng.comspringsource.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 15:41
 */
public class WindowCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment environment = context.getEnvironment();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Object person1 = beanFactory.getBean("person1");
        if (environment.getProperty("os.name").contains("Windows") && person1 != null) {
            return true;
        }
        return false;
    }
}
