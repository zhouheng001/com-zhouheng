package com.tujia.comdubboconsumer.controller;

import com.tujia.comdubboapi.domain.City;
import com.tujia.comdubboconsumer.controller.presentation.DubboPresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-28 上午 1:28
 */
@RestController
@RequestMapping("/test/dubbo")
public class DubboController {

    @Autowired
    private DubboPresentation dubboPresentation;

    @RequestMapping("/t1")
    public City getCity(){
        return dubboPresentation.getCity();
    }

    @RequestMapping("/t2")
    public City getCity1(){
        return dubboPresentation.getCity1();
    }

    @RequestMapping("/t3")
    public City getCity2(){
        return dubboPresentation.getCity2();
    }

    @RequestMapping("/t4")
    public City getCity3(){
        return dubboPresentation.getCity3();
    }

}
