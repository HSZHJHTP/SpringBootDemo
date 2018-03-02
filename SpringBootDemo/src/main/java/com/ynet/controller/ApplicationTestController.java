package com.ynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ynet.entity.People;

/**
 * @author hansz
 * @version 2018年2月23日 下午6:10:37
 * @Description TODO 读取配置文件中自定义的信息
 */
@RestController
public class ApplicationTestController {

	@Autowired
	People people;

	@Value("${person}")
	private String person;

	/**
	 * @author hansz
	 * @version 2018年2月23日 下午6:10:49
	 * @Description TODO 返回application文件中自己定义的people注入到实体类中的值,路径访问people1和people2都可以
	 */
	@RequestMapping(value = {"/people1", "/people2"}, method = { RequestMethod.POST, RequestMethod.GET })
	public People showPeople() {
		System.out.println(people);
		return people;
	}

	/**
	 * @author hansz
	 * @version 2018年2月24日 上午10:03:23
	 * @Description TODO 在application配置文件中使用application自己定义的内容然后注入
	 */
	@RequestMapping(value = "person", method = { RequestMethod.POST, RequestMethod.GET }, produces = "text/html; charset=utf-8")
	public String showPerson() {
		System.out.println(person);
		return "person";
	}

}
