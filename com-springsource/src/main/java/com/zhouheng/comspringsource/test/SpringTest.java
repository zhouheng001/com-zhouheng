package com.zhouheng.comspringsource.test;

import com.zhouheng.comspringsource.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:18
 */
public class SpringTest{
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        Person person = applicationContext.getBean(Person.class);
//        System.out.println(person);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Person bean = applicationContext.getBean(Person.class);
//        System.out.println(bean);
//        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            if(!beanDefinitionName.contains("context")){
                System.out.println(beanDefinitionName);
            }
        }

//        Environment environment = applicationContext.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.out.println(property);


    }
}
