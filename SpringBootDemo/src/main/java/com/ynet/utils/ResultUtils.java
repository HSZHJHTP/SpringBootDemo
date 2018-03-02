package com.ynet.utils;
/**
 * @author hansz
 * @version 2018年2月28日 下午3:02:56
 * @Description TODO 处理返回结果的工具类
 */

import com.ynet.entity.vo.ResultVo;

public class ResultUtils {
	
	public static ResultVo<Object> success(Object object) {
		ResultVo<Object> resultVo = new ResultVo<Object>(); 
		resultVo.setState("0");
		resultVo.setMessage("成功");
		resultVo.setData(object);
		return resultVo;
	}
	public static ResultVo<Object> success() {
		return success(null);
	}

	public static ResultVo<Object> error(String state,String message) {
		ResultVo<Object> resultVo = new ResultVo<Object>();
		resultVo.setState(state);
		resultVo.setMessage(message);
		return resultVo;
	}

}
