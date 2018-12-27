package com.tujia.comdubboapi.service;

import com.tujia.comdubboapi.domain.City;

/**
 * Create by Administrator on 2018/12/26 0026
 */
public interface CityDubboService {
    public City findCityByName(String cityName);
}
