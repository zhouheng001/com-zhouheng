package com.zhouheng.comspringsource.service;

import com.zhouheng.comspringsource.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:55
 */
@Service
public class UserService {

    /**
     * Autowired属于spring
     *
     * Resource和Inject属于java规范
     */
//    @Qualifier("userDao")
//    @Autowired(required = false)
//    @Resource(name = "userDao")
    @Inject
    private UserDao userDao1;

    public void Test(){
        System.out.println("输出userdao："+userDao1);
    }

}
