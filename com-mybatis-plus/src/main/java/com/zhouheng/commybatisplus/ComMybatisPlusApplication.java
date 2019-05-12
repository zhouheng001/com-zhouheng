package com.zhouheng.commybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhouheng.commybatisplus.dao")
public class ComMybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComMybatisPlusApplication.class, args);
	}

}
