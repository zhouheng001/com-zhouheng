package com.zhouheng.commyspring.beans;

/**
 * 描述:
 * 解析 BeanDefinition 的接口
 *
 * @author zhouheng
 * @create 2019-01-22 15:04
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location);
}
