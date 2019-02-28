package com.wq.spring.bean.dynamic.factory;

/**
 * @ClassName StudentFactory
 * @Description TODO
 * @Author wq
 * @Date 2019/2/14 10:35
 * @Version 1.0.0
 */
public class StudentFactory {


    public Student newInstance(){
        System.out.println("调用自定义的teachFactory");
        return new Student();
    }
}
