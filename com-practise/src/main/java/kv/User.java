package kv;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-02-18 下午 5:43
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5568657781708470125L;

    private int a;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        System.out.println(this.a);
    }
}
