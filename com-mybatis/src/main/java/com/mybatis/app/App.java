package com.mybatis.app;

import com.mybatis.anno.ZhouScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-20 下午 7:37
 */
@Configuration
@ComponentScan("com.mybatis")
@ZhouScan(basePackages = {"com.mybatis.mapper"})
public class App {

}
