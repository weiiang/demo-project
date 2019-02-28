package com.wq.spring.bean.dynamic.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author wq
 * @Date 2019/2/14 9:48
 * @Version 1.0.0
 */
public class TestMain {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //注册Bean
        final BeanDefined beanDefinedT = new BeanDefined();
        beanDefinedT.setBeanId("teacher");
        beanDefinedT.setBeanClass("com.wq.spring.bean.scope.Teacher");

        //注册Student,并配置自定义工厂
        final BeanDefined beanDefinedS = new BeanDefined();
        beanDefinedS.setBeanId("student");
        beanDefinedS.setBeanClass("com.wq.spring.bean.dynamic.factory.Student");
        beanDefinedS.setScope("prototype");
        beanDefinedS.setFactoryClass("com.wq.spring.bean.dynamic.factory.StudentFactory");
        beanDefinedS.setFactoryMethod("newInstance");

        //注册自定义的工厂
        final BeanDefined beanDefinedTF = new BeanDefined();
        beanDefinedTF.setBeanId("techaFactory");
        beanDefinedTF.setBeanClass("com.wq.spring.bean.dynamic.factory.StudentFactory");

        List<BeanDefined> beanDefinedList = new ArrayList<BeanDefined>(){{add(beanDefinedT); add(beanDefinedS);}};

        BeanFactory beanFactory = new BeanFactory(beanDefinedList);




        Student student = (Student) beanFactory.getBean("student");
        System.out.println(student);

        Student student1 = (Student) beanFactory.getBean("student");
        System.out.println(student1);
    }
}
