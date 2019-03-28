package com.tujia.com.dubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.tujia.comdubboapi.dao"})
public class ComDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComDubboProviderApplication.class, args);
    }
}

