package com.ynet.entity;

import java.io.Serializable;

/**
 * @author hansz
 * @version 2018年2月8日 下午11:16:54
 * @Description
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String password;
	private String name;
	private String sex;
	private Integer age;
	private String perms;

	public User() {

	}

	public User(Long id, String password, String name, String sex, Integer age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ ", perms=" + perms + "]";
	}

}
