package com.tujia.com.jdk8.lambda.vo;

import lombok.Data;

@Data
public class Employee {

    private String name;

    private int age;

    private double money;

    public Employee(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Employee(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }
}
