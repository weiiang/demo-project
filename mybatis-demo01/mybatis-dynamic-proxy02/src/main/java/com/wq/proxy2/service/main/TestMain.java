package com.wq.proxy2.service.main;

import com.wq.proxy2.service.SqlSession;
import com.wq.proxy2.service.factory.ProxyFactory;
import com.wq.proxy2.service.impl.DeptMapper;

import java.sql.SQLException;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author wq
 * @Date 2019/2/1 9:13
 * @Version 1.0.0
 */
public class TestMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, SQLException {
        String sql = "insert into dept(dname,loc,flag)values('shiye','cq',1)";
        SqlSession instance = ProxyFactory.getInstance(DeptMapper.class);
        int i = instance.save(sql);
        System.out.println("i="+i);
    }
}
