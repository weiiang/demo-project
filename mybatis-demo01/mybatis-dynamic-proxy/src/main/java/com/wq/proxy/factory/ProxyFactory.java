package com.wq.proxy.factory;

import com.wq.proxy.BaseService;
import com.wq.proxy.advice.Invocation;
import com.wq.proxy.impl.ServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Description 代理对象创建工厂
 * @Author wq
 * @Date 2019/1/31 16:52
 * @Version 1.0.0
 */
public class ProxyFactory {

    /**
     * 代理对象的类型应该由被监控的类型决定
     * type:被监控对象的类型
     */
    public static BaseService newInstatnce(Class type) throws IllegalAccessException, InstantiationException {
        //创建一个被监控的实例对象
        BaseService o = (BaseService) type.newInstance();
        InvocationHandler invocation = new Invocation(o);
        //向JVM申请负责监控BaseService的代理对象
        //loader:被监控对象类文件真实地址
        BaseService proxyInstance = (BaseService) Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), invocation);
        return proxyInstance;
    }
}
