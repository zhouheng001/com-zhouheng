package com.tujia.comaopandannotation.dao.impl;

import com.tujia.comaopandannotation.dao.TestDao;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-12 下午 11:28
 */
@Repository
public class TestDaoImpl implements TestDao {

    @Override
    public int getCount() {
        return 10;
    }
}
