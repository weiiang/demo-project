package com.wq.demo.staticed;

/**
 * @ClassName Father
 * @Description TODO
 * @Author wq
 * @Date 2019/2/2 9:46
 * @Version 1.0.0
 */
public class Father {

    private Person person;

    public Father(Person person){
        this.person = person;
    }

    public void findLoveForPerson(){
        System.out.println("给儿子找对象");
        this.person.findLove();
        System.out.println("自己觉得是否满意");
    }
}
