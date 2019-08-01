package com.sub;

import com.sub.dt.dao.IUserDao;
import com.sub.dt.pojo.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-04-04 上午 12:31
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        User user = new User();
//        user.setId(123423);
//        String id = BeanUtils.getProperty(user, "id");
//        System.out.println(id);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao bean = classPathXmlApplicationContext.getBean(IUserDao.class);
        System.out.println(bean);
    }
}
