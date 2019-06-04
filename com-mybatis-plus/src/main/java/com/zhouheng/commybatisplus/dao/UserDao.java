package com.zhouheng.commybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhouheng.commybatisplus.model.TUser0000;

import java.util.List;

/**
 * Create by Administrator on 2019/4/29 0029
 */
public interface UserDao extends BaseMapper<TUser0000> {

   void insertList(List<TUser0000> list);
}
