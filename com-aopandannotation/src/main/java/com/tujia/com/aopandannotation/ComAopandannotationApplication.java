package com.tujia.com.aopandannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.tujia.comdubboapi.*","com.tujia.com.aopandannotation.*"})
public class ComAopandannotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComAopandannotationApplication.class, args);
    }

}

