package com.zhouheng.comspringsource.config;

import com.zhouheng.comspringsource.dao.UserDao;
import com.zhouheng.comspringsource.pojo.dto.Boss;
import com.zhouheng.comspringsource.pojo.dto.Car;
import com.zhouheng.comspringsource.pojo.dto.Red;
import org.springframework.beans.factory.annotation.Autowired;
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
@ComponentScan(basePackages = {"com.zhouheng.comspringsource.service", "com.zhouheng.comspringsource.dao","com.zhouheng.comspringsource.pojo.dto"})
public class SpringConfigAutowired {

//    @Primary
    @Bean("userDao1")
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setLable(2);
        return userDao;
    }

    @Bean
    public Red red(){
        return new Red();
    }

    /**
     * 默认不写@Autowired，都能装配
     * @param car
     * @return
     */
    @Bean
    public Boss boss(/** @Autowired */ Car car){
        return new Boss(car);
    }

}
