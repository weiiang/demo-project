package com.wq.mybatis;

import com.wq.mybatis.dao.EmployeeMapper;
import com.wq.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author wq
 * @Date 2019/2/1 12:44
 * @Version 1.0.0
 */
public class TestMain {
    private SqlSession sqlSession = null;

    @Before
    public void beforeTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void afterTest(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    @org.junit.Test
    public void test1(){
        EmployeeMapper deptMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = deptMapper.findAll();
        list.forEach( l-> {
            System.out.println(l.toString());
        });
    }

    @org.junit.Test
    public void test2(){
        EmployeeMapper deptMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = deptMapper.findAll2();
        list.forEach( l-> {
            System.out.println(l.toString());
        });
    }



}
