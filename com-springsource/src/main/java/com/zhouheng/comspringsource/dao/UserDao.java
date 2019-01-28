package com.zhouheng.comspringsource.dao;

import org.springframework.stereotype.Repository;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:54
 */
@Repository
public class UserDao {
   private int lable=1;

    @Override
    public String toString() {
        return "UserDao{" +
                "lable=" + lable +
                '}';
    }

    public int getLable() {
        return lable;
    }

    public void setLable(int lable) {
        this.lable = lable;
    }
}
