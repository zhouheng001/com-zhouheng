package com.itheima.mybatis.mapper;

import com.itheima.mybatis.po.TUser0002;
import com.itheima.mybatis.po.TUser0002Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUser0002Dao {
    long countByExample(TUser0002Example example);

    int deleteByExample(TUser0002Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser0002 record);

    int insertSelective(TUser0002 record);

    List<TUser0002> selectByExample(TUser0002Example example);

    TUser0002 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser0002 record, @Param("example") TUser0002Example example);

    int updateByExample(@Param("record") TUser0002 record, @Param("example") TUser0002Example example);

    int updateByPrimaryKeySelective(TUser0002 record);

    int updateByPrimaryKey(TUser0002 record);
}