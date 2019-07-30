package com.tujia.com.jdk8.stream2;

import java.lang.annotation.*;

/**
 * Create by Administrator on 2018/11/21 0021
 */
@Documented
@Target(value = {ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface StudnetAnnotation {
    String warn() default "";

    int max();

    int min();
}
