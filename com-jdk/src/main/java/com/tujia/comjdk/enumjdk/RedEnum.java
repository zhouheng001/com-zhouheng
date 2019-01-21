package com.tujia.comjdk.enumjdk;

/**
 * 描述:
 *
 * @Author zhouheng
 * @Create 2018-11-25 下午 8:45
 */
public enum RedEnum {

    Min(10, 20), Max(20, 40);

    int x;

    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    RedEnum(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
