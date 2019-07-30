package com.tujia.com.jdk8.lambda.vo;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-15 上午 12:42
 */
public class A {

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public A() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof A))
            return false;
        A a1 = (A) obj;
        return a == a1.a;

    }

    @Override
    protected Object clone()
            throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize()
            throws Throwable {
        super.finalize();
    }
}
