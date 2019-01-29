package com.zhouheng.comspringsource.config;

import com.zhouheng.comspringsource.condition.LinuxCondition;
import com.zhouheng.comspringsource.condition.MyImportBeanDefinitionRegistrar;
import com.zhouheng.comspringsource.condition.MyImportSelector;
import com.zhouheng.comspringsource.condition.WindowCondition;
import com.zhouheng.comspringsource.pojo.dto.Color;
import com.zhouheng.comspringsource.pojo.dto.ColorFactoryBean;
import com.zhouheng.comspringsource.pojo.dto.Person;
import com.zhouheng.comspringsource.pojo.dto.Red;
import com.zhouheng.comspringsource.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:47
 *
 */

@ComponentScan(basePackages = {"com.zhouheng.comspringsource.pojo.dto"})
@Configuration
//@PropertySource(value = {"file:name.properties"})
@PropertySource(value = {"classpath:name.properties"})
public class SpringConfigLifeCycle {

    @Scope("prototype")
    @Bean(name = "person",initMethod = "init",destroyMethod = "destsory")
    public Person person(){
        return new Person();
    }

    @Bean(name = "color")
    public Color color(){
        return new Color();
    }
}
