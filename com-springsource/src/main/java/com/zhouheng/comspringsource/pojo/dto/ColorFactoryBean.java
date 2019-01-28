package com.zhouheng.comspringsource.pojo.dto;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-28 15:52
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        System.out.println("工厂获取对象");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
