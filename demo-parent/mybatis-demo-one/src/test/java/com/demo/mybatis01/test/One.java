package com.demo.mybatis01.test;

import com.demo.mybatis.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName One
 * @Description TODO
 * @Author wq
 * @Date 2019/1/21 9:20
 * @Version 1.0.0
 */

public class One {


    @Test
    public void test1() throws IOException {
        //创建配置文件读取流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
        //创建SqlSessionFactoryBuilder并用SessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(resourceAsStream);
        //用SqlSessionFactory获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Dept dept = new Dept();
        dept.setDname("金融事业部");
        dept.setLoc("北京");
        sqlSession.insert("insertDept",dept);
        sqlSession.commit();
        sqlSession.close();
    }

}
