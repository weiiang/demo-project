package com.wq.demo.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyBeanFactory
 * @Description TODO
 * @Author wq
 * @Date 2019/2/2 11:43
 * @Version 1.0.0
 */
public class ProxyBeanFactory {

    public static Person getInstance(Class clazz) throws IOException, IllegalAccessException, InstantiationException {
        Person person = (Person) clazz.newInstance();
        Father father = new Father(person);
        Person person1 = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), father);
        System.out.println("person代理對象:"+person1.toString());
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("E://proxy.class");
        os.write(bytes);
        os.close();
        System.out.println(new String(bytes, "UTF-8"));
        return person1;
    }
}
