package com.wq.proxy2.service.proxy;

import com.wq.proxy2.service.SqlSession;

import java.lang.reflect.Field;
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

    /**
     * 代理对象构造器
     * @param sqlSession   指定需要代理的接口
     */
    public DeptMapperProxy(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    /**
     * 次要业务1:
     *     加载驱动.    建立连接通道.   创建preapredStatement
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://119.23.220.195/kkb", "root", "root");
        preparedStatement = connection.prepareStatement("");
    }

    /**
     * 次要业务2
     *      关闭连接和preparedStatement
     * @throws SQLException
     */
    public void destroy() throws SQLException {
        if (this.preparedStatement != null){
            this.preparedStatement.close();
        }
        if (this.connection != null){
            this.connection.close();
        }
    }

    /**
     * 代理之后的主业务+次要业务逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        init();
        //反射给实现类的preparedStatement赋值
        Field ps = sqlSession.getClass().getDeclaredField("ps");
        ps.setAccessible(true);
        ps.set(sqlSession, this.preparedStatement);
        //执行目标方法
        Object invoke = method.invoke(sqlSession, args);
        destroy();
        return invoke;
    }
}
