package com.mybatis;

import com.mybatis.mapper.UserMapper;
import com.mybatis.proxy.MyInvocationJdkHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-20 下午 8:13
 */
public class ZhouFactoryBean<T> implements FactoryBean<T> {

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{UserMapper.class}, new MyInvocationJdkHandler());
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