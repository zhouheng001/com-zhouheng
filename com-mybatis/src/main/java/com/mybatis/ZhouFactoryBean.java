package com.mybatis;

import com.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-20 下午 8:13
 */
public class ZhouFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{UserMapper.class}, new MyInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}