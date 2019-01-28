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

@Configuration
//@ComponentScan(basePackages = {"com.zhouheng.comspringsource"})
@ComponentScans(value = {@ComponentScan(basePackages = {"com.zhouheng.comspringsource"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {UserService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyFilter.class})
        }, useDefaultFilters = false)

}
)
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class SpringConfig {

    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person() {
        return new Person("zhouheng", 22);
    }

    /**
     * {@link Person}
     * @see Person
     * @return
     */
    @Scope("prototype")
    @Bean("person1")
    public Person getPerson() {
        return new Person("zhouheng", 22);
    }

    /**
     * {@link Person}
     * @return
     */
    @Conditional(LinuxCondition.class)
    @Bean("bill")
    public Person bill() {
        return new Person("linux", 22);
    }

    @Conditional(WindowCondition.class)
    @Bean("zhouheng")
    public Person zhouheng() {
        return new Person("window", 22);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
