package com.zhouheng.jdk8.lambda.predict;

@FunctionalInterface
public interface MyPredict<T> {

     boolean test(T t);

     boolean equals(Object obj);
}
