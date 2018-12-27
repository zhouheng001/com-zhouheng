package com.tujia.comdubboconsumer.presentation;

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

    @Reference(version = "1.0.0")
    private CityDubboService cityDubboService;

    public City getCity(){
        return cityDubboService.findCityByName("齐齐哈尔");
    }

}
