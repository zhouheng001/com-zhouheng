package com.zhouheng.comspringsource.service;

import com.zhouheng.comspringsource.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:55
 */
@Service
@Order(0)
public class UserService {

    /**
     * Autowired属于spring
     *
     * @Autowired 1）可以放在set方法上
     * 2) 构造函数上(如果构造方法只有一个有参构造器,则可以省略注解)                   都是从容器中获取
     * 3) 放在参数位置
     * <p>
     * Resource和Inject属于java规范
     */
//    @Qualifier("userDao")
    @Autowired
//    @Resource(name = "userDao1")
    private UserDao userDao1;

    public void Test() {
        System.out.println("输出userdao：" + userDao1);
    }

    @Transactional
    public void insert() {
        userDao1.insert();
    }

}
