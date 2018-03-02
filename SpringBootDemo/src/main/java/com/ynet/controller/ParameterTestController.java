package com.ynet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hansz
 * @version 2018年2月23日 下午6:10:37
 * @Description TODO
 * 
 */
@RestController
@RequestMapping("/test")
public class ParameterTestController {

	/**
	 * @author hansz
	 * @version 2018年2月24日 上午11:19:10
	 * @Description TODO 获取url中的数据
	 */
	@RequestMapping(value = { "/parmTest1/{id}" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String showParmTest1(@PathVariable("id") Integer id) {
		return "id:" + id;
	}

	/**
	 * @author hansz
	 * @version 2018年2月24日 上午11:19:10
	 * @Description TODO 获取请求参数的值,required = false表示是否必传为false,defaultValue ="0"表示默认值为0,即如果未传值则为0
	 */
	@RequestMapping(value = { "/parmTest2" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String showParmTest2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		return "id:" + id;
	}

	/**
	 * @author hansz
	 * @version 2018年2月24日 上午11:41:07
	 * @Description TODO 即请求方法为get方法的@RequestMapping
	 */
	@GetMapping("/parmTest3")
	public String showParmTest3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		return "id:" + id;
	}

	/**
	 * @author hansz
	 * @version 2018年2月24日 上午11:41:07
	 * @Description TODO 即请求方法为post方法的@RequestMapping
	 */
	@PostMapping("/parmTest4")
	public String showParmTest4(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		return "id:" + id;
	}

}
