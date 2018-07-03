package com.ynet.controller;


import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hansz
 * @version 2018年2月11日 下午4:14:46
 * @Description TODO 跳转ftl页面
 */
@Controller
public class ShiroAndThymeleafTestController {

	@RequestMapping("/thymeleaf")
	public String toThymeleaf(Model model) {
		model.addAttribute("name", "韩圣章");
		return "thymeleaf";
	}

	@RequestMapping("/add")
	public String userAdd() {
		return "user/add";
	}

	@RequestMapping("/update")
	public String userUpdate() {
		return "user/update";
	}

	@RequestMapping("/toLogin")
	public String toLogin() {
		return "user/login";
	}

	@RequestMapping("/login")
	public String login(String name, String password, Model model) {
		/**
		 * 使用Shiro编写认证操作
		 */
		// 1.忽的Shiro编写认证从操作
		Subject subject = SecurityUtils.getSubject();

		// 2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		
		// 3.执行登录方法
		try {
			subject.login(token);
			// 登陆成功
			return "redirect:/thymeleaf";
		} catch (UnknownAccountException e) {
			// 登录失败：用户名不存在
			model.addAttribute("msg", "用户名不存在");
			return "user/login";
		} catch (IncorrectCredentialsException e) {
			// 登录失败：密码错误
			model.addAttribute("msg", "密码错误");
			return "user/login";
		}
	}

}
