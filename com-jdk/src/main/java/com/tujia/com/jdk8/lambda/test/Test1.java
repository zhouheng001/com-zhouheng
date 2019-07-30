package com.tujia.com.jdk8.lambda.test;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-15 上午 12:00
 */
public class Test1 {

    public static void main(String[] args) {

        List<Integer> nums = null;
        String name = null;

        if (StringUtils.isEmpty(name)) {
            System.out.println("c3shi");
        }
        if (StringUtils.isBlank(name)) {
            System.out.println("isblank");
        }
        name = " ";
        if (StringUtils.isEmpty(name)) {
            System.out.println("c3shi");
        }

        if (StringUtils.isBlank(name)) {
            System.out.println("isblank");
        }

        if (CollectionUtils.isEmpty(nums)) {
            System.out.println("集合是isEmpty");
        }
        if (CollectionUtils.isEmpty(nums)) {
            System.out.println("集合是isEmpty");
        }
        nums = new ArrayList<>();
        if (CollectionUtils.isEmpty(nums)) {
            System.out.println("集合是isEmpty");
        }

        if (!name.equals(1)) {
            System.out.println(1);
        }

    }
}
