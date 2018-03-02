package com.ynet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching //开启缓存，集成redis单机作为缓存时使用
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //刚创建项目没有连接数据库时需要加上下面
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
