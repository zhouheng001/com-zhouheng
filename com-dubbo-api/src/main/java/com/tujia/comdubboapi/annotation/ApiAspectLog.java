package com.tujia.comdubboapi.annotation;

import java.lang.annotation.*;

/**
 * Create by Administrator on 2019/3/5 0005
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiAspectLog {
    /**
     * ApiTraceLog 日志名 用于BI统计，非BI要求无需设置
     *
     * @return
     */
     String traceName() default "";

    /**
     * ApiTraceLog 日志版本号 用于BI统计，非BI要求无需设置
     *
     * @return
     */
    String version() default "1.0";

    /**
     * 是否记录 ApiTraceLog 对于一些无业务意义的API不进行记录
     *
     * @return
     */
    boolean traceLogEnabled() default true;
}
