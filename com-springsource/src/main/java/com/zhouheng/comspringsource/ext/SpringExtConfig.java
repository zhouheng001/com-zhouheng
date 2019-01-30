package com.zhouheng.comspringsource.ext;

import com.zhouheng.comspringsource.dao.UserDao;
import com.zhouheng.comspringsource.pojo.dto.Blue;
import com.zhouheng.comspringsource.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouheng
 * @Description:
 *
 * @create 2019-01-30 11:19
 */
@ComponentScan(basePackages = {"com.zhouheng.comspringsource.ext"})
@Configuration
public class SpringExtConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
