package com.tujia.comaopandannotation.service.impl;

import com.tujia.comaopandannotation.dao.TestDao;
import com.tujia.comaopandannotation.service.TestService;
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
