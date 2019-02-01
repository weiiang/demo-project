package com.wq.proxy2.service.impl;

import com.wq.proxy2.service.SqlSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName DeptMapper
 * @Description 接口实现类
 * @Author wq
 * @Date 2019/1/31 18:05
 * @Version 1.0.0
 */
public class DeptMapper implements SqlSession {
    private PreparedStatement ps;
    public int save(String sql) throws SQLException {
        return ps.executeUpdate(sql);
    }
}
