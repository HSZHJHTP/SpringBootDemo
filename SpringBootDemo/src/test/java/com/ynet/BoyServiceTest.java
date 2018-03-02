package com.ynet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ynet.entity.Boy;
import com.ynet.service.BoyService;

/**
 * @author hansz
 * @version 2018年2月28日 下午9:36:22
 * @Description TODO 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoyServiceTest {
	@Autowired
	BoyService boyService;
	
	@Test
	public void findOneTest() {
		Boy boy = boyService.findOneBoy(15);
		Assert.assertEquals(new Integer(14), boy.getAge());//使用断言测试返回的内容是否为14
	}

}
