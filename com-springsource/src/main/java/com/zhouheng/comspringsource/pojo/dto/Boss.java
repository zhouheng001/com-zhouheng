package com.zhouheng.comspringsource.pojo.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 22:27
 */
//@Component
public class Boss {

//    @Autowired
    private Car car;

    public Car getCar() {
        return car;
    }

//    @Autowired
    public void setCar( Car car) {
        this.car = car;
    }

//    @Autowired
    public Boss(/** @Autowired */Car car) {
        this.car=car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
