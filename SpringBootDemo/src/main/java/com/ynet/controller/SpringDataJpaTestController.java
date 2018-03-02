package com.ynet.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ynet.dao.repository.BoyRepository;
import com.ynet.entity.Boy;
import com.ynet.service.BoyService;

/**
 * @author hansz
 * @version 2018年2月27日 下午4:54:16
 * @Description TODO 测试jpa
 */
@RestController
public class SpringDataJpaTestController {
	@Autowired
	BoyRepository boyRepository;
	@Autowired
	BoyService boyService;

	/**
	 * @author hansz
	 * @version 2018年2月27日 下午5:11:03
	 * @Description TODO 查询所有
	 */
	@GetMapping("/findAll")
	public List<Boy> findAll() {
		return boyRepository.findAll();
	}

	/**
	 * @author hansz
	 * @version 2018年2月27日 下午5:17:43
	 * @Description TODO 新增
	 */
	@PostMapping("/save")
	public Boy save(@RequestParam("age") Integer age, @RequestParam("name") String name) {
		Boy boy = new Boy();
		boy.setAge(age);
		boy.setName(name);
		return boyRepository.save(boy);
	}

	/**
	 * @author hansz
	 * @version 2018年2月27日 下午5:17:43
	 * @Description TODO 单个查询
	 */
	@GetMapping("/findOne/{id}")
	public Boy findOne(@PathVariable("id") Integer id) {
		return boyRepository.findOne(id);
	}
	
	/**
	 * @author hansz
	 * @version 2018年2月27日 下午5:17:43
	 * @Description TODO 多个查询,需要在service自己写方法，需要通过哪个属性查就写findBy属性名（属性名首字母大写）
	 */
	@GetMapping("/findByAge/{age}")
	public List<Boy> findByAge(@PathVariable("age") Integer age) {
		return boyRepository.findByAge(age);
	}

	/**
	 * @author hansz
	 * @version 2018年2月27日 下午5:17:43
	 * @Description TODO 更新
	 */
	@PutMapping("/update/{id}")
	public Boy updateOne(@PathVariable("id") Integer id, @RequestParam("age") Integer age, @RequestParam("name") String name) {
		Boy boy = new Boy();
		boy.setId(id);
		boy.setAge(age);
		boy.setName(name);
		return boyRepository.save(boy);
	}

	/**
	 * @author hansz
	 * @version 2018年2月27日 下午5:17:43
	 * @Description TODO 删除
	 */
	@DeleteMapping("/delete/{id}")
	public void deleteOne(@PathVariable("id") Integer id) {
		boyRepository.delete(id);
	}
	
	/**
	 * @author hansz
	 * @version 2018年2月27日 下午11:29:31
	 * @Description TODO 测试事务
	 */
	@GetMapping("/insertTwo")
	public void insertTwo() {
		boyService.insertTwo();
	}
	
	/**
	 * @author hansz
	 * @version 2018年2月28日 上午11:07:14
	 * @Description TODO 验证boy的年龄是否满18:@Valid-检验，验证结果返回到BindingResult对象中
	 */
	@PostMapping("/verifyBoy")
	public Boy verifyBoy(@Valid Boy boy,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return null;
		}
		return boyRepository.save(boy);
	}
	
	/**
	 * @author hansz
	 * @version 2018年2月28日 下午5:35:25
	 * @Description TODO 获取Boy年龄并通过统一异常处理返回内容
	 */
	@GetMapping("/getBoyAge/{id}")
	public void getBoyAge(@PathVariable("id") Integer id) {
		boyService.getBoyAge(id);
	}

}
