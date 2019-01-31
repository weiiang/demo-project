package com.wq.demo.test;

import com.wq.demo.mapper.DeptMapper;
import com.wq.demo.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName DeptFactoryTest
 * @Description TODO
 * @Author wq
 * @Date 2019/1/31 11:03
 * @Version 1.0.0
 */
public class DeptFactoryTest {
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

    @Test
    public void test1(){
        Dept dept = new Dept();
        dept.setDname("部门名称");
        dept.setFlag(false);
        dept.setLoc("地址");
        sqlSession.insert("insertDept", dept);
        sqlSession.commit();
    }


    @Test
    public void test2(){

        DeptMapper dao = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = dao.findAll();
        list.forEach(l -> {
            System.out.println(l.toString());
        });
    }
}
