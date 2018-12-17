package com.pc.springbootdemo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//表示获取前缀为 sutdent 的配置信息
@ConfigurationProperties(prefix="student")
public class StudentPropertity {
	//此处的属性名要和配置文件中的值对应，不然取不到值
	private String name3;
	private Integer age3;
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public Integer getAge3() {
		return age3;
	}
	public void setAge3(Integer age3) {
		this.age3 = age3;
	}
	
	
}
