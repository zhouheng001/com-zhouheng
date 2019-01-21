package com.zhouheng.commyspring.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface HLPService {
    String value() default "";
}
