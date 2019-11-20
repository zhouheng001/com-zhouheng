package com.zhouheng.jdk8.Pattern;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.operationNums(num1, num2);
    }
}