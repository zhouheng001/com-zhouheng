package com.tujia.comjdk.enumjdk;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-25 下午 8:48
 */
public class Test {
    public static void main(String[] args) {

        RedEnum redEnum = RedEnum.Min;
        if (RedEnum.Max.getX() == redEnum.getX()) {
            redEnum = RedEnum.Max;
        } else if (RedEnum.Min.getX() == redEnum.getX()) {
            redEnum = RedEnum.Min;
        }
        System.out.println(redEnum.getY());
    }
}
