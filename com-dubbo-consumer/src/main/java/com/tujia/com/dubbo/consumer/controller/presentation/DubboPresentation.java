package com.tujia.com.dubbo.consumer.controller.presentation;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tujia.com.dubbo.api.po.TUser0000;
import com.tujia.comdubboapi.domain.City;
import com.tujia.comdubboapi.service.CityDubboService;
import com.tujia.comdubboapi.service.TUser0000Service;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-28 上午 1:34
 */
@Component
public class DubboPresentation {

    @Reference(version = "1.0.0", group = "CityDubboService1")
    private CityDubboService cityDubboService;

    @Reference(version = "1.0.0", group = "CityDubboService2")
    private CityDubboService cityDubboService1;

    @Reference(version = "1.0.0", group = "CityDubboService3")
    private CityDubboService cityDubboService2;

    @Reference(version = "1.0.0", group = "CityDubboService4")
    private CityDubboService cityDubboService3;

    @Reference(version = "1.0.0", group = "TUser0000Service")
    private TUser0000Service tUser0000Service;

    public City getCity() {
        return cityDubboService.findCityByName("齐齐哈尔");
    }

    public City getCity1() {
        return cityDubboService1.findCityByName("齐齐哈尔");
    }

    public City getCity2() {
        return cityDubboService2.findCityByName("齐齐哈尔");
    }

    public City getCity3() {
        return cityDubboService3.findCityByName("齐齐哈尔");
    }

    public int deleteByPrimaryKey(Integer id) {
        return tUser0000Service.deleteByPrimaryKey(id);
    }

    public int insert(TUser0000 record) {
        return tUser0000Service.insert(record);
    }

    public TUser0000 selectByPrimaryKey(Integer id) {
        return tUser0000Service.selectByPrimaryKey(id);
    }

}
