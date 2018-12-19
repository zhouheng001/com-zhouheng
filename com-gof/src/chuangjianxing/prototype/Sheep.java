package chuangjianxing.prototype;

import java.util.Date;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-11-25 下午 9:51
 */
public class Sheep implements Cloneable{
   private String name;
   private Date birthday;

    public Sheep() {
    }

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();

        Sheep sheep =  (Sheep) clone;
        sheep.birthday = (Date) this.birthday.clone();
        return clone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
