package com.mybatis.anno;

import com.mybatis.register.ZhouScanRegisterScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-20 下午 7:39
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(ZhouScanRegisterScan.class)
public @interface ZhouScan {
    @AliasFor("basePackages")
    String[] value() default {};

    @AliasFor("value")
    String[] basePackages() default {};
}
