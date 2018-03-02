package com.ynet.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hansz
 * @version 2018年2月23日 下午6:06:59
 * @Description TODO
 */
@Component
@ConfigurationProperties(prefix = "people") // 注入配置文件中自己定义的people,下面需要有set方法，或者在成员变量上直接使用@Vaule("${people.属性名}")
public class People {
	private Integer age;
	private String name;

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

	@Override
	public String toString() {
		return "People [age=" + age + ", name=" + name + "]";
	}

}
