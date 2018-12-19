package com.pc.springbootdemo.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 3.测试自定义异常
 * @author caipch
 * @date 2018年12月19日
 */
@Controller
public class TestException {

	@RequestMapping("/exception")
	public String test() throws Exception{
		throw  new MyException("100", "自定义异常");
	}
	
	/**
	 * 通过注解@ModelAttribute获取model中的内容
	 * @param author
	 */
	@RequestMapping("/model1")
	public void  getModel(@ModelAttribute("author") String author) {
		System.out.println(author);
	}
	
	/**
	 * 通过modelmap来获取model里面的属性
	 * @param modelMap
	 */
	@RequestMapping("model2")
	public void getModel2(ModelMap modelMap) {
		System.out.println(modelMap.get("author"));
	}
}
