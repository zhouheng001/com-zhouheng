package com.tujia.comdubboconsumer.controller.presentation;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tujia.comdubboapi.domain.City;
import com.tujia.comdubboapi.service.CityDubboService;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-28 上午 1:34
 */
@Component
public class DubboPresentation {

    @Reference(version = "1.0.0",group = "CityDubboService1")
    private CityDubboService cityDubboService;

    @Reference(version = "1.0.0",group = "CityDubboService2")
    private CityDubboService cityDubboService1;

    @Reference(version = "1.0.0",group = "CityDubboService3")
    private CityDubboService cityDubboService2;

    @Reference(group = "CityDubboService4")
    private CityDubboService cityDubboService3;

    public City getCity(){
        return cityDubboService.findCityByName("齐齐哈尔");
    }

    public City getCity1(){
        return cityDubboService1.findCityByName("齐齐哈尔");
    }

    public City getCity2(){
        return cityDubboService2.findCityByName("齐齐哈尔");
    }

    public City getCity3(){
        return cityDubboService3.findCityByName("齐齐哈尔");
    }

}
