package com.tujia.com.dubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan(value = {"com.tujia.comdubboapi.dao"})
public class ComDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComDubboProviderApplication.class, args);
    }
}

