package com.wq.mybatis.test;

import com.wq.mybatis.DeptMapper;
import com.wq.mybatis.pojo.Dept;
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
 * @ClassName Test
 * @Description TODO
 * @Author wq
 * @Date 2019/2/1 10:24
 * @Version 1.0.0
 */
public class Test {

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
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = deptMapper.findList("dname");
        list.forEach( l-> {
            System.out.println(l.toString());
        });
    }


    @org.junit.Test
    public void test2(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = deptMapper.findDeptByValue2("dept");
        list.forEach( l-> {
            System.out.println(l.toString());
        });
    }

    @org.junit.Test
    public void test3(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = deptMapper.findDeptByValue("dept");
        list.forEach( l-> {
            System.out.println(l.toString());
        });
    }

}
