package com.wq.demo.factory;

import com.wq.demo.pojo.Dept;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

/**
 * @ClassName DeptFactory
 * @Description TODO
 * @Author wq
 * @Date 2019/1/31 10:53
 * @Version 1.0.0
 */
public class DeptFactory  extends DefaultObjectFactory {

    @Override
    public Object create(Class type) {//重新定义Dept类实例对象创建规则，其他类实例对象创建规则不想改变

        if(Dept.class == type){
            //依靠父类提供create方法创建Dept实例对象
            Dept dept=(Dept) super.create(type);
            //设置自定义规则
            dept.setCountry("China");
            return dept;
        }
        return super.create(type);
    }
}
