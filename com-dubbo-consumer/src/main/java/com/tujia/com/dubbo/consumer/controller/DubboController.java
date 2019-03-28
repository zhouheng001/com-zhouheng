package com.tujia.com.dubbo.consumer.controller;

import com.tujia.com.dubbo.api.po.TUser0000;
import com.tujia.com.dubbo.consumer.controller.presentation.DubboPresentation;
import com.tujia.comdubboapi.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public City getCity() {
        return dubboPresentation.getCity();
    }

    @RequestMapping("/t2")
    public City getCity1() {
        return dubboPresentation.getCity1();
    }

    @RequestMapping("/t3")
    public City getCity2() {
        return dubboPresentation.getCity2();
    }

    @RequestMapping("/t4")
    public City getCity3() {
        return dubboPresentation.getCity3();
    }

    @RequestMapping(value = "/add/{tel}",method = RequestMethod.GET)
    public String insert(@PathVariable String tel){
        TUser0000 tUser0000 = new TUser0000();
        tUser0000.setAge(13);
        tUser0000.setUserNum(tel);
        tUser0000.setPassword("123456");
        tUser0000.setUserName("周恒");
        dubboPresentation.insert(tUser0000);
        return "success";
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String del(@PathVariable Integer id){
        dubboPresentation.deleteByPrimaryKey(id);
        return "success";
    }

    @RequestMapping(value = "/select/{id}",method = RequestMethod.GET)
    public TUser0000 select(@PathVariable Integer id){
        TUser0000 tUser0000 = dubboPresentation.selectByPrimaryKey(id);
        return tUser0000;
    }

}
