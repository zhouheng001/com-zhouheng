package com.zhouheng.comspringsource.dao;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:54
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public void insert(){
        String sql="INSERT INTO `tbl_user`(username,age) VALUES(?,?)";
        String substring = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,substring,19);
    }
}
