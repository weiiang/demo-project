package com.wq.spring.demo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName CustomBeanPostProcessor
 * @Description TODO
 * @Author wq
 * @Date 2019/2/14 13:54
 * @Version 1.0.0
 */
public class CustomBeanPostProcessor implements CustomBeanPostProcessorInterface {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("postProcessBeforeInitialization start......");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("postProcessAfterInitialization start......");
        Class beanInstance = bean.getClass();
        if (beanInstance.equals(ISomeService.class)){
            Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("doSomeThing 被拦截......");
                    String result = (String) method.invoke(bean, args);
                    return result.toUpperCase();
                }
            });
        }
        return bean;
    }
}
