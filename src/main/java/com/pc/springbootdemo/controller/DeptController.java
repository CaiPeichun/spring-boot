package com.pc.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pc.springbootdemo.dao.DeptDao;
import com.pc.springbootdemo.entity.Dept;
/**
 * 用来测试springboot+hibernate连接oracle
 * @author caipch
 * @date 2018年12月17日
 */
@RestController
public class DeptController {
	@Autowired
	private DeptDao deptDao;
	
	@RequestMapping("/dept")
	public String add() {
		Dept dept = new Dept();
		dept.setDeptno(123);
		dept.setDname("123");
		dept.setLoc("123");
		deptDao.save(dept);
		System.out.println("success");
		return "ok";
		
	}
}
