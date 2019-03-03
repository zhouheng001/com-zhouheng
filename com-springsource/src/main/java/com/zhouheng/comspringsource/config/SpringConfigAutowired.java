package com.zhouheng.comspringsource.config;

import com.zhouheng.comspringsource.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 19:07
 */
@Configuration
@ComponentScan(basePackages = {"com.zhouheng.comspringsource.service"})
public class SpringConfigAutowired {

    //    @Primary
    @Bean("userDao1")
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setLable(2);
        return userDao;
    }

//    @Bean
//    public Red red() {
//        return new Red();
//    }

//    /**
//     * 默认不写@Autowired，都能装配
//     *
//     * @param car
//     * @return
//     */
//    @Bean
//    public Boss boss(/** @Autowired */Car car) {
//        return new Boss(car);
//    }
}
