package com.tujia.comdubboprovider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.tujia.comdubboapi.domain.City;
import com.tujia.comdubboapi.service.CityDubboService;

// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {
 
    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}