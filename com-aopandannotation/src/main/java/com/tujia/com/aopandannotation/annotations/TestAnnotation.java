package com.tujia.com.aopandannotation.annotations;

import com.tujia.com.aopandannotation.myenum.TestEnum;

import java.lang.annotation.*;

/**
 * Create by Administrator on 2018/12/12 0012
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestAnnotation {

    TestEnum testEnum() default TestEnum.APP;

    String name() default "no name";
}
