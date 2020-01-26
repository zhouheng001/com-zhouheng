package com.example.comwebsocket;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
 
/**
 * @Author：JCccc
 * @Description：
 * @Date： created in 15:56 2019/5/13
 */
@SpringBootApplication
@EnableScheduling //该注解是开启定时任务的支持
public class WebsocketApplication extends SpringBootServletInitializer {


//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(WebsocketApplication.class);
//	}

	public static void main(String[] args)

	{
		SpringApplication.run(WebsocketApplication.class, args);
	}
 
}