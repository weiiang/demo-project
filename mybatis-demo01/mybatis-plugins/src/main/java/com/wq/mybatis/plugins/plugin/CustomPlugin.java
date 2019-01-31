package com.wq.mybatis.plugins.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @ClassName CustomPlugin
 * @Description TODO
 * @Author wq
 * @Date 2019/1/31 12:42
 * @Version 1.0.0
 */
//注解声明
@Intercepts(value = {
        @Signature(type = Executor.class,
                    method = "query",
                    args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class CustomPlugin implements Interceptor {
    /**
     * 拦截加入的具体逻辑
     *
     * @param invocation Object target;  代理对象
     *                   Method method;  被监控的方法
     *                   final Object[] args;    被监控的方法需要的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("被拦截方法执行之前");
        //执行被拦截的方法
        Object proceed = invocation.proceed();
        System.out.println("被拦截方法执行之后");
        return proceed;
    }

    /**
     * 判断是否需要拦截
     *
     * @param o 被拦截的对象:执行器接口的实例对象
     *          作用:
     *          如果被拦截的对象所在的类有实现的接口,就为当前拦截的对象生成一个代理对象
     *          如果被拦截的对象所在的类没有实现的接口,这个对象之后行为就不会被代理操作
     * @return
     */
    @Override
    public Object plugin(Object o) {
        //返回的是被代理的对象
        return Plugin.wrap(o, this);
    }

    /**
     * 读取配置文件
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
