package com.wq.proxy.advice;

import com.wq.proxy.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName Invocation
 * @Description 通知:告诉主业务在做主业务之前需要怎么做
 * @Author wq
 * @Date 2019/1/31 16:30
 * @Version 1.0.0
 */
public class Invocation implements InvocationHandler {

    /**
     * 监控的行为抽象
     */
    private BaseService baseService;

    /**
     * 创建通知的时候需要指定监控谁
     * @param obj
     */
    public Invocation (BaseService obj){
        this.baseService = obj;
    }


    /**
     * 在被监控的行为将要执行的时候,拦截住这个方法.
     * 被监控方法的信息会被作为参数传递进来
     *      与主业务的方法绑定执行
     * @param proxy  代理对象(执行主业务方法对象的代理对象)
     * @param method 被拦截的方法
     * @param args   运行时所有的实参封装在数组中
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //确认当前呗拦截的方法
        String methodName = method.getName();
        //根据被拦截的行为的不同决定如何将次要业务和主要业务绑定执行
        Object invoke = null;
        if ("eat".equals(methodName)){
            //先洗手后吃饭
            wash();
            invoke = method.invoke(this.baseService, args);
            invoke = "eat";
        }

        if ("ec".equals(methodName)){
            //先上厕所后洗手
            invoke = method.invoke(this.baseService, args);
            wash();
            invoke = "ec";
        }
        return invoke;
    }

    /**
     * 次要业务
     */
    public void wash(){
        System.out.println("洗手");
    }

}
