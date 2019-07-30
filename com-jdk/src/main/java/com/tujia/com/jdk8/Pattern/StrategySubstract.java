package com.tujia.com.jdk8.Pattern;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-20 上午 12:04
 */
public class StrategySubstract implements Strategy {

    @Override
    public int operationNums(int v1, int v2) {
        return v1 - v2;
    }
}
