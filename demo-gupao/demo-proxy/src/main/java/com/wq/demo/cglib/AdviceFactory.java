package com.wq.demo.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @ClassName AdviceFactory
 * @Description TODO
 * @Author wq
 * @Date 2019/2/2 12:34
 * @Version 1.0.0
 */
public class AdviceFactory {

    public  static Object getInstance(Class clazz){

        CglibAdvice cglibAdvice = new CglibAdvice();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(cglibAdvice);

        return enhancer.create();
    }

}
