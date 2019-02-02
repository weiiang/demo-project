package com.wq.demo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName Father
 * @Description TODO
 * @Author wq
 * @Date 2019/2/2 11:42
 * @Version 1.0.0
 */
public class Father implements InvocationHandler {

    private Person person;

    public Father(Person person){
        this.person = person;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        if (methodName.indexOf("findLove") != -1){
            beforeFindLove();
            this.person.findLove();
            afterFindLove();
        }else if (methodName.indexOf("zhfangzi") != -1){
            beforezhfangzi();
            this.person.zhfangzi();
            afterzhfangzi();
        }else if (methodName.indexOf("job") != -1){
            beforeJob();
            this.person.job();
            afterJob();
        }else if (methodName.indexOf("buy") != -1){
            beforeBuy();
            this.person.buy();
            afterBuy();
        }


        return null;
    }

    private void beforeFindLove() {
        System.out.println("帮找对象之前");
    }

    private void afterFindLove() {
        System.out.println("帮找对象之后");
    }

    private void beforeBuy() {
        System.out.println("帮买东西之前");
    }

    private void afterBuy() {
        System.out.println("帮买东西之后");
    }

    private void beforezhfangzi() {
        System.out.println("帮租房子之前");
    }

    private void afterzhfangzi() {
        System.out.println("帮租房子之后");
    }

    private void beforeJob() {
        System.out.println("帮找工作之前");
    }

    private void afterJob() {
        System.out.println("帮找工作之后");
    }
}
