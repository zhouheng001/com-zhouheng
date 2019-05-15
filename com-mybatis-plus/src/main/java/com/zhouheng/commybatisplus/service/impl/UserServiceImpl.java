package com.zhouheng.commybatisplus.service.impl;

import com.zhouheng.commybatisplus.common.DatasourceEnum;
import com.zhouheng.commybatisplus.dao.UserDao;
import com.zhouheng.commybatisplus.db.annotation.DataSource;
import com.zhouheng.commybatisplus.model.TUser0000;
import com.zhouheng.commybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-15 下午 11:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @DataSource(DatasourceEnum.DATA_SOURCE_ZHOUHENG)
    public TUser0000 getTUser0000(int id) {
        return userDao.selectById(id);
    }

}
