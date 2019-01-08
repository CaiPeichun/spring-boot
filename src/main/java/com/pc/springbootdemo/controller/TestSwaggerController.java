package com.pc.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="cai")
@RestController
public class TestSwaggerController {

	@ApiOperation(value="swaggertest")
	@GetMapping("/hello")
	public String  hello() {
		return "hello swagger";
	}
}
