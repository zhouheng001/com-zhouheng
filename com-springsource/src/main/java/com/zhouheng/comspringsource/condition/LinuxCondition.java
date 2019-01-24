package com.zhouheng.comspringsource.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 15:41
 */
public class LinuxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment environment = context.getEnvironment();
        if(environment.getProperty("os.name").contains("linux")){
            return true;
        }
        return false;
    }
}
