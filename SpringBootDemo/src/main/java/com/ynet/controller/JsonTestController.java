package com.ynet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynet.entity.User;

/**
 * @author hansz
 * @version 2018年2月8日 下午10:52:29
 * @Description
 */
@RestController
public class JsonTestController {

	/**
	 * @author hansz
	 * @version 2018年2月8日 下午11:15:23
	 * @Description 返回基本json格式数据
	 */
	@RequestMapping("/hello")
	public String showHello() {
		return "hello world";
	}

	/**
	 * @author hansz
	 * @version 2018年2月8日 下午11:22:19
	 * @Description 返回实体类对象
	 */
	@RequestMapping("/user")
	public User showUser() {
		User user = new User(1L, "123", "张三", "男", 24);
		return user;
	}

	/**
	 * @author hansz
	 * @version 2018年2月10日 上午12:15:50
	 * @Description 返回map
	 */
	@RequestMapping("/map")
	public Map<String, Object> showMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "李四");
		map.put("user", new User(1L, "123", "张三", "男", 24));
		return map;

	}

	/**
	* @author hansz
	* @version 2018年2月10日 上午12:30:44
	* @Description 返回list
	*/
	@RequestMapping("/list")
	public List<User> showList() {
		List<User> list = new ArrayList<>();
		for (Long i = 0L; i < 10L; i++) {
			String sex = "";
			if (i % 2 == 0) {
				sex = "男";
			} else {
				sex = "女";
			}
			User user = new User(i, "123", "张" + i, sex, (int) (20L + i));
			list.add(user);
		}
		return list;

	}

}
