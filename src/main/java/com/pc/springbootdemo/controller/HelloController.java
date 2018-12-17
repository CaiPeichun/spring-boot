package com.pc.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pc.springbootdemo.entity.StudentPropertity;
/**
 * 取yml中值的三种方式
 * 1.直接配置直接取
 * 2.在yml中先取
 * 3.用一个对象封装后再取
 * @author caipch
 * @date 2018年12月17日
 */
@RestController
public class HelloController {

	@Value("${name1}")
	private String name;
	
	@Value("${age1}")
	private Integer age;
	
	@Value("${content}")
	private String content;
	
	@Autowired
	private StudentPropertity studentpro;
	
	@RequestMapping("/hello")
	public String hello() {
		return name+age;
	}
	
	@RequestMapping("/hello2")
	public String hello2() {
		return content;
	}
	
	@RequestMapping("/hello3")
	public String hello3() {
		return studentpro.getName3()+studentpro.getAge3();
	}
}
