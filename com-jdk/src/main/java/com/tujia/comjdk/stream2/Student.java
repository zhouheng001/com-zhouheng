package com.tujia.comjdk.stream2;

import lombok.Data;

/**
 * 描述: 学生
 *
 * @author zhouheng
 * @create 2018-11-07 上午 12:18
 */
@Data
public class Student {

    @StudnetAnnotation(max = 20, min = 5)
    private Integer age;

    private String name;

    @Override
    public String toString() {
        return "Car{" + "age=" + age + ", sex='" + sex + '\'' + '}';
    }

    public Student() {
    }

    public Student(Integer age, String sex) {

        this.age = age;
        this.sex = sex;
    }

    @Deprecated
    public Integer getAge() {

        return age;
    }

    void test() {

    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String sex;

}
