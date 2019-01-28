package com.zhouheng.comspringsource.config;

import com.zhouheng.comspringsource.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 19:07
 */
@Configuration
@ComponentScan(basePackages = {"com.zhouheng.comspringsource.service", "com.zhouheng.comspringsource.dao"})
public class SpringConfigAutowired {

//    @Primary
    @Bean("userDao1")
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setLable(2);
        return userDao;
    }

}
