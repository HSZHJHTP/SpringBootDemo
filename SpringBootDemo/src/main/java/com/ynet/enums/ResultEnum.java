package com.ynet.enums;

/**
 * @author hansz
 * @version 2018年2月28日 下午9:04:24
 * @Description TODO 枚举，返回信息的种类
 */
public enum ResultEnum {
	UNKNOW_ERROR("-1", "未知错误"), SUCCESS("0", "成功"), PRIMARY_SCHOOL("100", "你可能还在上小学"), MIDDLE_SCHOOL("101", "你可能在上初中");

	private String state;
	private String message;

	private ResultEnum(String state, String message) {
		this.state = state;
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public String getMessage() {
		return message;
	}

}
