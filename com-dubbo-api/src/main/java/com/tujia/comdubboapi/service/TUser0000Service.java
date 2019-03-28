package com.tujia.comdubboapi.service;

import com.tujia.com.dubbo.api.po.TUser0000;
import com.tujia.com.dubbo.api.po.TUser0000Example;

import java.util.List;

/**
 * Create by Administrator on 2019/3/28 0028
 */
public interface TUser0000Service {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser0000 record);

    int insertSelective(TUser0000 record);

    List<TUser0000> selectByExample(TUser0000Example example);

    TUser0000 selectByPrimaryKey(Integer id);
}
