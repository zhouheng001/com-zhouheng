package com.zhouheng.commyspring.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-21 18:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HLPAutowired {
    String value() default "";
}
