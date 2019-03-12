package com.itheima.mybatis.mapper;

import com.itheima.mybatis.po.TUser0000;
import com.itheima.mybatis.po.TUser0000Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUser0000Dao {
    long countByExample(TUser0000Example example);

    int deleteByExample(TUser0000Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser0000 record);

    int insertSelective(TUser0000 record);

    List<TUser0000> selectByExample(TUser0000Example example);

    TUser0000 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser0000 record, @Param("example") TUser0000Example example);

    int updateByExample(@Param("record") TUser0000 record, @Param("example") TUser0000Example example);

    int updateByPrimaryKeySelective(TUser0000 record);

    int updateByPrimaryKey(TUser0000 record);
}