package com.wq.spring.demo;

/**
 * @ClassName ISomeService
 * @Description TODO
 * @Author wq
 * @Date 2019/2/14 13:51
 * @Version 1.0.0
 */
public class ISomeService implements BaseService {
    @Override
    public String doSomeThing() {
        System.out.println("doSomeThing begain");
        return "Hello World";
    }
}
