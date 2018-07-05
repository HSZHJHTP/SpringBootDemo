package com.ynet.service;
/**
* @author hansz
* @version 2018年2月10日 下午2:38:28
* @Description 
*/

import java.util.List;

import com.ynet.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findByName(String name);
	
	public List<User> findAllAndRedisCache();
	
	public String findRedisCluster();
	
	public User findById(Long id);

}
