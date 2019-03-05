package com.zhouheng.comspringsource.annotation;

import java.lang.annotation.*;

/**
 * Create by Administrator on 2019/3/4 0004
 */
@Documented
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {

    String value() default "myannotaion";
}
