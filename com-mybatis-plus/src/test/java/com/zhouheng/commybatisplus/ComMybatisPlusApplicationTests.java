package com.zhouheng.commybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhouheng.commybatisplus.dao.UserDao;
import com.zhouheng.commybatisplus.model.TUser0000;
import com.zhouheng.commybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ComMybatisPlusApplicationTests {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		TUser0000 tUser0000 = userDao.selectById(13);
		System.out.println(tUser0000.getUserName());
	}

	@Test
	public void getTUser0000() {
//		TUser0000 tUser0000 = userService.getTUser0000(13);
		QueryWrapper<TUser0000> queryWrapper = new QueryWrapper<>();
		Integer count = userDao.selectCount(queryWrapper);
		System.out.println(count);
	}

	@Test
	public void insertTUser0000() {
		TUser0000 tUser0000 = new TUser0000();
		tUser0000.setUserName("周恒");
		tUser0000.setPassword("123456");
		tUser0000.setUserNum("15101516443");
		tUser0000.setAge(13);
		List<TUser0000> list = new ArrayList<>();
		for (int i=0;i<1000000;i++){
			list.add(tUser0000);
		}

		long l = System.currentTimeMillis();
		userDao.insertList(list);
		long l1 = System.currentTimeMillis();
		System.out.println(l1-l);
	}
}
