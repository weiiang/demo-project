package com.wq.spring.bean.scope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BeanFactory
 * @Description TODO
 * @Author wq
 * @Date 2019/2/14 9:33
 * @Version 1.0.0
 */
public class BeanFactory {

    private List<BeanDefined> beanDefinedList;
    private Map<String, Object> scopeBeanList = new HashMap<String, Object>();

    public BeanFactory(List<BeanDefined> beanDefinedList) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.beanDefinedList = beanDefinedList;
        if (beanDefinedList.size() > 0) {
            for (BeanDefined beanDefined : beanDefinedList) {
                if ("singleton".equals(beanDefined.getScope())) {
                    this.scopeBeanList.put(beanDefined.getBeanId(), Class.forName(beanDefined.getBeanClass()).newInstance());
                }
            }
        }
    }

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }

    public Object getBean(String beanId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object instance = null;
        System.out.println(this.beanDefinedList.toString());
        for (BeanDefined beanDefined : this.beanDefinedList) {
            if (beanId.equals(beanDefined.getBeanId())) {
                //单例Bean
                System.out.println(beanDefined.toString());
                if ("singleton".equals(beanDefined.getScope())) {
                    return this.scopeBeanList.get(beanId);
                } else {
                    //原型Bean
                    Class clazz = Class.forName(beanDefined.getBeanClass());
                    instance = clazz.newInstance();
                }
            }

        }
        return instance;
    }
}
