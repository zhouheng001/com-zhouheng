package chuangjianxing.prototype;

import java.util.Date;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-25 下午 9:58
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Sheep s1 = new Sheep("多利",date);
        Sheep clone = (Sheep) s1.clone();
        Sheep s2 = s1;
        s1.setName("多利2");
        s2.setName("多利3");
//        System.out.println(s1.getBirthday());
//        date.setTime(123123123L);
//        System.out.println(s1.getBirthday());
        System.out.println(s1);
        System.out.println(s2);
//        System.out.println(clone.getBirthday());
        System.out.println(clone);
    }
}
