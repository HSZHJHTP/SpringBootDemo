package com.ynet.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ynet.aspect.HttpAspect;
import com.ynet.entity.vo.ResultVo;
import com.ynet.exception.BoyException;
import com.ynet.utils.ResultUtils;

/**
 * @author hansz
 * @version 2018年2月28日 下午2:53:27
 * @Description TODO 异常捕获，并且统一处理异常
 */
@ControllerAdvice
public class ExceptionHandle {
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultVo<Object> handle(Exception e) {
		if (e instanceof BoyException) {
			BoyException boyException = (BoyException) e;
			return ResultUtils.error(boyException.getState(), boyException.getMessage());
		} else {
			logger.error("【系统异常】{}",e);
			return ResultUtils.error("-1", "未知错误");
		}
	}

}
