package com.tujia.com.aopandannotation.service.impl;

import com.tujia.com.aopandannotation.dao.TestDao;
import com.tujia.com.aopandannotation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-12 下午 11:31
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public int getCount() {
        return testDao.getCount();
    }
}
