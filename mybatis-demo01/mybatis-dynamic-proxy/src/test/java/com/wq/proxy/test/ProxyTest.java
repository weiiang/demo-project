package com.wq.proxy.test;

import com.wq.proxy.BaseService;
import com.wq.proxy.factory.ProxyFactory;
import com.wq.proxy.impl.ServiceImpl;
import org.junit.Test;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author wq
 * @Date 2019/1/31 17:05
 * @Version 1.0.0
 */
public class ProxyTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        BaseService baseService = ProxyFactory.newInstatnce(ServiceImpl.class);
        System.out.println(baseService.eat());
    }

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        BaseService baseService = ProxyFactory.newInstatnce(ServiceImpl.class);
        baseService.ec();
    }
}
