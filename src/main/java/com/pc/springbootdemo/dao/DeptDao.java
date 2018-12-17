package com.pc.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pc.springbootdemo.entity.Dept;

public interface DeptDao extends JpaRepository<Dept, Integer>{

}
