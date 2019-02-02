package com.wq.demo.cglib;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author wq
 * @Date 2019/2/2 12:36
 * @Version 1.0.0
 */
public class TestMain {

    public static void main(String[] args) {
//        ZhangSan obj = (ZhangSan) new CglibAdvice().getInstance(ZhangSan.class);
        ZhangSan obj = (ZhangSan) AdviceFactory.getInstance(ZhangSan.class);
        obj.findLove();
    }
}
