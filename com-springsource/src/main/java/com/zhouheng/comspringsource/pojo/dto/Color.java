package com.zhouheng.comspringsource.pojo.dto;

import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 16:14
 */
@Data
public class Color {
    @Value(value = "#{20-2}")
    private int age;
    @Value(value = "张三")
    private String name;
    @Value(value = "${color.name}")
    private String nickname;
}
