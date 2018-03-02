package com.ynet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author hansz
 * @version 2018年2月27日 下午4:38:17
 * @Description TODO spring data jpa的实体类
 */
@Entity
public class Boy {
	@Id
	@GeneratedValue
	private Integer id;
	@Min(value = 18,message = "未成年禁止入内") //规定最小值为18，如果值小于18就会返回message中的信息
	private Integer age;
	private String name;

	public Boy() {
	}

	public Boy(Integer id, Integer age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public Boy(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
