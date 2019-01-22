package com.zhouheng.commyspring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-22 14:55
 */
public class PropertyValues {

    private List<PropertyValues> propertyValues = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValues(PropertyValues propertyValues) {
        this.propertyValues.add(propertyValues);
    }

    public void setPropertyValues(List<PropertyValues> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
