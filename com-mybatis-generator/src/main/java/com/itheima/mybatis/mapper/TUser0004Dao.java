package com.itheima.mybatis.mapper;

import com.itheima.mybatis.po.TUser0004;
import com.itheima.mybatis.po.TUser0004Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUser0004Dao {
    long countByExample(TUser0004Example example);

    int deleteByExample(TUser0004Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser0004 record);

    int insertSelective(TUser0004 record);

    List<TUser0004> selectByExample(TUser0004Example example);

    TUser0004 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser0004 record, @Param("example") TUser0004Example example);

    int updateByExample(@Param("record") TUser0004 record, @Param("example") TUser0004Example example);

    int updateByPrimaryKeySelective(TUser0004 record);

    int updateByPrimaryKey(TUser0004 record);
}