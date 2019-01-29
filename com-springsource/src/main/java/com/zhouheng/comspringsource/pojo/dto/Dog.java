package com.zhouheng.comspringsource.pojo.dto;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 17:38
 */
@Component
public class Dog {

    public Dog(){
        System.out.println("dog 初始化...");
    }

    @PostConstruct
    public void init(){
        System.out.println("dog  @PostConstruct");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("dog    @PreDestroy");
    }

}
