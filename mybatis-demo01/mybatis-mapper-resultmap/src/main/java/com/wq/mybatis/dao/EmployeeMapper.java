package com.wq.mybatis.dao;

import com.wq.mybatis.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> findAll();

    List<Employee> findAll2();
}
