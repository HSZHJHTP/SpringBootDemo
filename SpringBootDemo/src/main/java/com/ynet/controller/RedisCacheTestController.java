package com.ynet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynet.entity.User;
import com.ynet.service.UserService;

/**
 * @author hansz
 * @version 2018年2月10日 下午9:07:14
 * @Description TODO redis
 */
@RestController
public class RedisCacheTestController {
	@Autowired
	UserService userService;

	/**
	 * @author hansz
	 * @version 2018年2月10日 下午10:52:44
	 * @Description TODO redis单机做缓存
	 */
	@RequestMapping("/redisCacheUsers")
	public List<User> showRedisCacheUsers() {
		return userService.findAllAndRedisCache();
	}
	
	/**
	 * @author hansz
	 * @version 2018年2月10日 下午10:53:52
	 * @Description TODO 查询redis集群服务
	 */
	@RequestMapping("/redisClusterTest")
	public String showRedisClusterTest() {
		return userService.findRedisCluster();
	}

}
