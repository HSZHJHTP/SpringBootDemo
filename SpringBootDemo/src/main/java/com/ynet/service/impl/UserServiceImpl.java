package com.ynet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ynet.dao.mapper.UserMapper;
import com.ynet.entity.User;
import com.ynet.service.UserService;

import redis.clients.jedis.JedisCluster;

/**
 * @author hansz
 * @version 2018年2月10日 下午2:49:59
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper UserMapper;
	
	//注入redis集群对象，即RedisConfig中的@Bean标签下的内容
	@Autowired
	JedisCluster jedisCluster;

	@Override
	public List<User> findAll() {
		return UserMapper.findAll();
	}
	
	@Override
//	@Cacheable(value = "findAllUsers") //设置缓存（这里用的是redis做缓存），意思是在缓存区域开启一个名称空间为findAllUsers的缓存，存储查询的数据，下次会根据findAll这个名称去寻找有没有这个缓存
	public List<User> findAllAndRedisCache() {
		System.out.println("如果第二次没有打印这一句，说明走了缓存，没有执行此方法");
		return UserMapper.findAll();
	}

	@Override
	public String findRedisCluster() {
		jedisCluster.set("username", "韩圣章");
		return jedisCluster.get("username");
	}

}
