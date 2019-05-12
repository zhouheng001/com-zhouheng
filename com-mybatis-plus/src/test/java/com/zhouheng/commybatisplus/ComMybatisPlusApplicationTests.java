package com.zhouheng.commybatisplus;

import com.zhouheng.commybatisplus.dao.UserDao;
import com.zhouheng.commybatisplus.model.TUser0000;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ComMybatisPlusApplicationTests {

	@Autowired
	private UserDao userDao;


	@Test
	public void contextLoads() {
		TUser0000 tUser0000 = userDao.selectById(13);
		System.out.println(tUser0000.getUserName());
	}


}
