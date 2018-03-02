package com.ynet.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynet.dao.repository.BoyRepository;
import com.ynet.entity.Boy;
import com.ynet.enums.ResultEnum;
import com.ynet.exception.BoyException;
import com.ynet.service.BoyService;

/**
 * @author hansz
 * @version 2018年2月27日 下午11:31:22
 * @Description TODO
 */
@Service
public class BoyServiceImpl implements BoyService {
	@Autowired
	BoyRepository boyRepository;

	@Transactional //数据库事务的标签
	public void insertTwo() {
		Boy boy1 = new Boy(15, "安抚啊");
		boyRepository.save(boy1);
		Boy boy2 = new Boy(42, "阿萨达爱我擦");
		boyRepository.save(boy2);
	}

	@Override
	public void getBoyAge(Integer id) {
		Boy boy = boyRepository.findOne(id);
		int age = boy.getAge();
		if (age < 10) {
			throw new BoyException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age > 10 && age < 16){
			throw new BoyException(ResultEnum.MIDDLE_SCHOOL);
		}
	}

	@Override
	public Boy findOneBoy(Integer id) {
		Boy boy = boyRepository.findOne(id);
		return boy;
	}
}
