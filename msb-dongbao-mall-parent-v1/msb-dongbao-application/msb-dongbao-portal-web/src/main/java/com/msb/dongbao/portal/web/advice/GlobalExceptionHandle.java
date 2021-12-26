package com.msb.dongbao.portal.web.advice;

import com.msb.dongbao.common.base.TokenException;
import com.msb.dongbao.common.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2021/1/12
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(ArithmeticException.class)
	public ResultWrapper customException(){
		return ResultWrapper.builder().code(301).msg("统一异常").build();
	}

	/**
	 * 自定义 token异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(TokenException.class)
	public ResultWrapper loginException(Exception e){
		return ResultWrapper.getFailBuilder().code(501).msg(e.getMessage()).build();
	}


}
