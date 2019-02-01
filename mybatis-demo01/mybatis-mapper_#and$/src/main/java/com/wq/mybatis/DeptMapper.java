package com.wq.mybatis;

import com.wq.mybatis.pojo.Dept;

import java.util.List;

/**
 * @ClassName dao
 * @Description TODO
 * @Author wq
 * @Date 2019/2/1 10:03
 * @Version 1.0.0
 */
public interface DeptMapper {

    List<Dept> findList(String param);

    List<Dept> findDeptByValue2(String param);

    List<Dept> findDeptByValue(String param);
}
