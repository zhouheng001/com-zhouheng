package com.itheima.mybatis.mapper;

import com.itheima.mybatis.po.TUser0003;
import com.itheima.mybatis.po.TUser0003Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUser0003Dao {
    long countByExample(TUser0003Example example);

    int deleteByExample(TUser0003Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser0003 record);

    int insertSelective(TUser0003 record);

    List<TUser0003> selectByExample(TUser0003Example example);

    TUser0003 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser0003 record, @Param("example") TUser0003Example example);

    int updateByExample(@Param("record") TUser0003 record, @Param("example") TUser0003Example example);

    int updateByPrimaryKeySelective(TUser0003 record);

    int updateByPrimaryKey(TUser0003 record);
}