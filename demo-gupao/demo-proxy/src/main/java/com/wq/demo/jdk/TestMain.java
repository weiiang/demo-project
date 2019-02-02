package com.wq.demo.jdk;

import java.io.IOException;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author wq
 * @Date 2019/2/2 11:54
 * @Version 1.0.0
 */
public class TestMain {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        Person person = ProxyBeanFactory.getInstance(Son.class);
        person.buy();
        person.findLove();
        person.job();
        person.zhfangzi();
    }
}
