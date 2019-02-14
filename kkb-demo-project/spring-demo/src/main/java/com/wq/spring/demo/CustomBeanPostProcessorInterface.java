package com.wq.spring.demo;


public interface CustomBeanPostProcessorInterface {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }


    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

}
