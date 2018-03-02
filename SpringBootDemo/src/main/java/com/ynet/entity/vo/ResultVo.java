package com.ynet.entity.vo;

/**
 * @author hansz
 * @version 2018年2月28日 下午2:55:42
 * @param <T>
 * @Description TODO 工具类
 */
public class ResultVo<T> {

	private String state;
	private String message;
	private T data;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
