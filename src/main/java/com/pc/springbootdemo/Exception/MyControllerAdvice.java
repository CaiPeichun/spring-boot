package com.pc.springbootdemo.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 2.全局异常处理类：controller增强器
 * @author caipch
 * @date 2018年12月19日
 */
@ControllerAdvice
public class MyControllerAdvice {

	/**
	 * 应用到所有@requestMapping注解方法，在其执行之前初始化数据绑定器
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
	}
	
	/**
	 * 把值绑定到Model中，使全局@requestMapping可以获取到该值
	 */
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("author", "caipch");
	}
	
	/**
	 * 全局异常捕捉处理
	 */
	@ResponseBody
	@ExceptionHandler(value=MyException.class)
	public Map errorHandler(MyException exception) {
		Map map = new HashMap();
		map.put("code", exception.getCode());
		map.put("msg", exception.getMsg());
		return map;
	}
}
