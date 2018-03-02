package com.ynet.service;

import com.ynet.entity.Boy;

/**
 * @author hansz
 * @version 2018年2月27日 下午11:14:46
 * @Description TODO 测试事务
 */
public interface BoyService {

	public void insertTwo();

	public void getBoyAge(Integer id);
	
	public Boy findOneBoy(Integer id);

}
