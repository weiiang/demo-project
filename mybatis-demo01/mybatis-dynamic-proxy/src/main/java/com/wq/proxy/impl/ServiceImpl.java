package com.wq.proxy.impl;

import com.wq.proxy.BaseService;

/**
 * @ClassName ServiceImpl
 * @Description 实现类
 * @Author wq
 * @Date 2019/1/31 16:26
 * @Version 1.0.0
 */
public class ServiceImpl implements BaseService {

    /**
     * 只关心主要业务
     */
    public String eat() {
        System.out.println("吃饭");
        return "eat";
    }

    /**
     * 只关心主要业务
     */
    public String ec() {
        System.out.println("上厕所");
        return "ec";
    }

}
