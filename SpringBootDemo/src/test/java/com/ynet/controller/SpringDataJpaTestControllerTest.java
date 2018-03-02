package com.ynet.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author hansz
 * @version 2018年2月28日 下午10:17:07
 * @Description TODO 测试controller
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc//测试controller时添加此标签
public class SpringDataJpaTestControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/findAll1")).andExpect(MockMvcResultMatchers.status().isOk())//测试/findAll请求是否可用
				.andExpect(MockMvcResultMatchers.content().string("abc"));//测试返回内容是否为abc，结果报错
	}

}
