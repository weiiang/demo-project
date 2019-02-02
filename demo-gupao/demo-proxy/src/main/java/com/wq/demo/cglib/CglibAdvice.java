package com.wq.demo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibAdvice
 * @Description TODO
 * @Author wq
 * @Date 2019/2/2 12:31
 * @Version 1.0.0
 */
public class CglibAdvice implements MethodInterceptor {


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       methodProxy.invokeSuper(o, objects);
        return null;
    }
}
