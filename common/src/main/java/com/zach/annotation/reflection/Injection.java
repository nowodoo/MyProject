package com.zach.annotation.reflection;

/**
 * 注入类，将person注入Injection对象中去
 */
public class Injection {
    @SelfAnnotation(name = "Person")
    static Person person;

    public void show() {
        System.out.println(person.getName() + "," + person.getAge());
    }

}  