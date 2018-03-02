package com.ynet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hansz
 * @version 2018年2月11日 下午4:14:46
 * @Description TODO 跳转ftl页面
 */
@Controller
public class FtlTestController {
	@RequestMapping("/ftl")
	public String toFtl() {
		return "index";

	}

}
