package com.pc.springbootdemo.Exception;
/**
 * 1.自定义异常类
 * @author caipch
 * @date 2018年12月19日
 */
public class MyException extends RuntimeException{

	private String code;
	private String msg;
	
	public MyException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
