package com.pc.springbootdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ���ű��ʵ����
 * 
 * @author caipch
 * @date 2018��12��12��
 */
@Entity
@Table(name = "dept")
public class Dept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "DEPTNO")
	private Integer deptno;
	@Column(name = "DNAME")
	private String dname;
	@Column(name = "LOC")
	private String loc;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "���� [���ű��=" + deptno + ", ��������=" + dname + ", λ��=" + loc + "]";
	}

}
