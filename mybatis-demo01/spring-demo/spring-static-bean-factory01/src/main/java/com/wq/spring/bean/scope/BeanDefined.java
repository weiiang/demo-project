package com.wq.spring.bean.scope;

/**
 * @ClassName BeanDefined
 * @Description TODO
 * @Author wq
 * @Date 2019/2/14 9:31
 * @Version 1.0.0
 */
public class BeanDefined {

    private String beanId;
    private String beanClass;
    private String scope = "singleton";

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public String toString() {
        return "BeanDefined{" +
                "beanId='" + beanId + '\'' +
                ", beanClass='" + beanClass + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
