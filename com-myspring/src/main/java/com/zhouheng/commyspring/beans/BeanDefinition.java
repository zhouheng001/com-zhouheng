package com.zhouheng.commyspring.beans;

/**
 * 描述:
 * 保存Bean定义
 *
 * @author zhouheng
 * @create 2019-01-22 14:53
 */
public class BeanDefinition {

    /**
     * 装bean名字
     */
    private String beanClassName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public BeanDefinition() {
    }

    public BeanDefinition(String beanClassName, Class beanClass, PropertyValues propertyValues) {
        this.beanClassName = beanClassName;
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * 装bean反射类
     */
    private Class beanClass;
    /**
     * 装bean中的各个属性值
     */
    private PropertyValues propertyValues;

}
