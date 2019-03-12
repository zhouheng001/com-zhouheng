package com.itheima.mybatis.mapper;

import com.itheima.mybatis.po.TUser0001;
import com.itheima.mybatis.po.TUser0001Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUser0001Dao {
    long countByExample(TUser0001Example example);

    int deleteByExample(TUser0001Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser0001 record);

    int insertSelective(TUser0001 record);

    List<TUser0001> selectByExample(TUser0001Example example);

    TUser0001 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser0001 record, @Param("example") TUser0001Example example);

    int updateByExample(@Param("record") TUser0001 record, @Param("example") TUser0001Example example);

    int updateByPrimaryKeySelective(TUser0001 record);

    int updateByPrimaryKey(TUser0001 record);
}