package com.zhouheng.commybatisplus.db.annotation;

import java.lang.annotation.*;

/**
 * Create by Administrator on 2019/5/15 0015
 *  @see
 */

@Documented
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default "";
}
