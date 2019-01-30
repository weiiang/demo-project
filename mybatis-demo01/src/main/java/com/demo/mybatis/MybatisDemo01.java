package com.demo.mybatis;

import com.demo.mybatis.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MybatisDemo01
 * @Description TODO
 * @Author wq
 * @Date 2019/1/30 10:50
 * @Version 1.0.0
 */
public class MybatisDemo01 {
    public static void main(String[] args) throws IOException {
        test1();
    }

    public static void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dept dept = new Dept();
        dept.setDname("研发部");
        dept.setLoc("重庆");
        sqlSession.insert("insertDept", dept);
        sqlSession.commit();
        sqlSession.close();
    }
}
