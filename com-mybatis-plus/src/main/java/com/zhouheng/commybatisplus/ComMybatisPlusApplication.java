package com.zhouheng.commybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ComMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComMybatisPlusApplication.class, args);
    }

}
