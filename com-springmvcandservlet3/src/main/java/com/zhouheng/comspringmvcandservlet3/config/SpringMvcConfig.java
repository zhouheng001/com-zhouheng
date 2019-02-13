package com.zhouheng.comspringmvcandservlet3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-02-13 14:52
 */
@ComponentScan(basePackages = {"com.zhouheng.comspringmvcandservlet3"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
},useDefaultFilters = false)
public class SpringMvcConfig {

}
