package com.zhouheng.comspringmvcandservlet3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-02-13 15:00
 */
@RestController
public class TestController {

    @RequestMapping
    public String test1() {
        return "123";
    }
}
