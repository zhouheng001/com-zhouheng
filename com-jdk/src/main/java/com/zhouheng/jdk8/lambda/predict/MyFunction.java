package com.zhouheng.jdk8.lambda.predict;

@FunctionalInterface
public interface MyFunction<T , R> {

     R apply(T... t);

}
