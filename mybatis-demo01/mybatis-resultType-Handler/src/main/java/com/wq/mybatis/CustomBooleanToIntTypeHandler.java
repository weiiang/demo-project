package com.wq.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 利用的是代理模式
 * 这些方法都相当于通知
 * @ClassName CustomBooleanToIntTypeHandler
 * @Description TODO
 * @Author wq
 * @Date 2019/1/30 17:44
 * @Version 1.0.0
 */
public class CustomBooleanToIntTypeHandler implements TypeHandler<Dept> {

    /**
     * 生成相关的SQL语句的时候调用的
     * @param preparedStatement
     * @param i 占位符位置
     * @param dept 部门
     * @param jdbcType
     * @throws SQLException
     */
    public void setParameter(PreparedStatement preparedStatement, int i, Dept dept, JdbcType jdbcType) throws SQLException {
        System.out.println("falg:"+dept.getFlag());
        if (dept.getFlag() == null){
            preparedStatement.setInt(i, 0);
            return;
        }
        Boolean flag = (Boolean) dept.getFlag();
        if (flag){
            preparedStatement.setInt(i ,10);
        }else {
            preparedStatement.setInt(i, 20);
        }

    }

    /**
     * 在查询的结束之后将ResultSet数据行转换为实体类类型时:通知typehandler将当前数据行的某个字段转换为指定类型
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    public Dept getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    public Dept getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    public Dept getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
