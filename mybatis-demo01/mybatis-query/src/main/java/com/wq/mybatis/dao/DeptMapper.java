package com.wq.mybatis.dao;

import com.wq.mybatis.pojo.Dept;

import java.util.List;

public interface DeptMapper {

    List<Dept> findAll();
}
