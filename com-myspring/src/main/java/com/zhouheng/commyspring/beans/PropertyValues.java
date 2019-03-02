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

    public PropertyValues() {
    }

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
