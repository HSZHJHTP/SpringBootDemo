package com.ynet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynet.entity.User;
import com.ynet.service.UserService;

/**
 * @author hansz
 * @version 2018年2月10日 下午2:52:28
 * @Description
 */
@RestController
public class MybatisTestController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/mybatisUsers")
	public List<User> showMybatisUsers() {
		return userService.findAll();
	}

}
