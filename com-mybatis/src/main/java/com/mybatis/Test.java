package com.mybatis;

import com.mybatis.app.App;
import com.mybatis.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-20 下午 8:00
 */
public class Test {
    public static void main(String[] args) {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        applicationContext.start();
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        userMapper.query(1);

    }
}
