package com.wq.spring.demo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BeanFactory
 * @Description TODO
 * @Author wq
 * @Date 2019/2/14 14:04
 * @Version 1.0.0
 */
public class BeanFactory {
    private List<BeanDefined> beanDefinedList;
    private Map<String, Object> scopeBeanMap;
    //后置对象
    private CustomBeanPostProcessorInterface customBeanPostProcessorInterface;

    public BeanFactory(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }
}
