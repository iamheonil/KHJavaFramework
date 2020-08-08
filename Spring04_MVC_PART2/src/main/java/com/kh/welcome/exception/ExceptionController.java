package com.kh.welcome.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import common.exception.CustomException;
import common.exception.ErrorCode;

// @ControllerAdvice - 지정한 패키지 내의 모든 클래스가 @ExceptionHandler 어노테이션이
// 지정된 메소드를 공유하도록 해준다
@ControllerAdvice(basePackages = { "com.kh.welcome" })
@Controller
public class ExceptionController {

	@ExceptionHandler(CustomException.class)
	public ModelAndView ex(CustomException e) {
		
		ModelAndView mav = new ModelAndView();
		
		// ErrorCode.valueOf("") : 매개변수로 넘어간 문자열과 이름이 일치하는 Enum 인스턴스를 반환
		mav.addObject("alertMsg", ErrorCode.valueOf(e.getMessage()));
		mav.addObject("url", ErrorCode.valueOf(e.getMessage()).getURL());
		mav.setViewName("common/result");
			
		return mav;
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ex(Exception e) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("alertMsg", "에러가 발생함");
		mav.addObject("url", "login.do");
		mav.setViewName("common/result");

		return mav;

	}

}
