package com.wq.proxy2.service.factory;

import com.wq.proxy2.service.SqlSession;
import com.wq.proxy2.service.proxy.DeptMapperProxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Description 代理对象Bean工厂
 * @Author wq
 * @Date 2019/2/1 9:01
 * @Version 1.0.0
 */
public class ProxyFactory {

    /**
     * 代理对象工厂方法
     *
     * @param type
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static SqlSession getInstance(Class type) throws IllegalAccessException, InstantiationException {


        //创建呗监控的实例对象
        SqlSession sqlSession = (SqlSession) type.newInstance();

        //创建通知对象
        DeptMapperProxy deptMapperProxy = new DeptMapperProxy(sqlSession);

        //注册JDK代理
        SqlSession sqlSession1 = (SqlSession) Proxy.newProxyInstance(sqlSession.getClass().getClassLoader(), sqlSession.getClass().getInterfaces(), deptMapperProxy);

        return sqlSession1;
    }
}
