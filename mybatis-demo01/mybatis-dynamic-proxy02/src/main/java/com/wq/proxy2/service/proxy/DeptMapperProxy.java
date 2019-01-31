package com.wq.proxy2.service.proxy;

import com.wq.proxy2.service.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName DeptMapperProxy
 * @Description TODO
 * @Author wq
 * @Date 2019/1/31 18:07
 * @Version 1.0.0
 */
public class DeptMapperProxy  implements InvocationHandler {

    private SqlSession sqlSession;

    private PreparedStatement preparedStatement;
    private Connection connection;


    public DeptMapperProxy(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://119.23.220.195", "root", "root");
        preparedStatement = connection.prepareStatement("");
    }

    public void destroy() throws SQLException {
        if (this.preparedStatement != null){
            this.preparedStatement.close();
        }
        if (this.connection != null){
            this.connection.close();
        }
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        init();
        //执行目标方法

        destroy();
        return null;
    }
}
