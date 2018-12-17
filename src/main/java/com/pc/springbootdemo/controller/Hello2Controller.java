package com.pc.springbootdemo.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 返回一个jsp页面——hello.jsp
 * @author caipch
 * @date 2018年12月17日
 */
@Controller
public class Hello2Controller {

	@RequestMapping("/hello4")
	public String hello(Model model) {
		model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
		return "hello";
	}
}
