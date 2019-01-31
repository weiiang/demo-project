package com.wq.mybatis.pluguns.test;

import com.wq.mybatis.plugins.mapper.DeptMapper;
import com.wq.mybatis.plugins.pojo.Dept;
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
 * @ClassName PluginsTest
 * @Description TODO
 * @Author wq
 * @Date 2019/1/31 11:47
 * @Version 1.0.0
 */
public class PluginsTest {

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
    public void test2(){
        DeptMapper dao = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = dao.findAll();
        list.forEach(l -> {
            System.out.println(l.toString());
        });
    }
}
