package com.ynet.exception;

import com.ynet.enums.ResultEnum;

/**
 * @author hansz
 * @version 2018年2月28日 下午3:23:41
 * @Description TODO 自定义异常，spring框架只有抛出RuntimeException时才会进行事务回滚，抛出Exception时不会进行事务回滚
 */
public class BoyException extends RuntimeException {
	private String state;

	public BoyException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.state = resultEnum.getState();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
