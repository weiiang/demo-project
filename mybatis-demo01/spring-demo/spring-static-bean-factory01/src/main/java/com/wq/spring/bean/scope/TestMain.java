package com.wq.spring.bean.scope;

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
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //注册Bean
        final BeanDefined beanDefinedT = new BeanDefined();
        beanDefinedT.setBeanId("teacher");
        beanDefinedT.setBeanClass("com.wq.spring.bean.scope.Teacher");

        final BeanDefined beanDefinedS = new BeanDefined();
        beanDefinedS.setBeanId("student");
        beanDefinedS.setBeanClass("com.wq.spring.bean.scope.Student");
        beanDefinedS.setScope("prototype");

        List<BeanDefined> beanDefinedList = new ArrayList<BeanDefined>(){{add(beanDefinedT); add(beanDefinedS);}};

        BeanFactory beanFactory = new BeanFactory(beanDefinedList);


        Teacher teacher = (Teacher) beanFactory.getBean("teacher");
        System.out.println(teacher);

        Teacher teacher1 = (Teacher) beanFactory.getBean("teacher");
        System.out.println(teacher1);

        Student student = (Student) beanFactory.getBean("student");
        System.out.println(student);

        Student student1 = (Student) beanFactory.getBean("student");
        System.out.println(student1);
    }
}
