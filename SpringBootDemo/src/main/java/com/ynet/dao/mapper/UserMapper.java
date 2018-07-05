package com.ynet.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ynet.entity.User;

/**
* @author hansz
* @version 2018年2月10日 下午2:41:28
* @Description mybatis
*/
@Mapper
public interface UserMapper {
	
	/**
	* @author hansz
	* @version 2018年2月10日 下午2:42:30
	* @Description 查询所有用户
	*/
	public List<User> findAll();
	
	public User findByName(String name);
	
	public User findById(Long id);

}
