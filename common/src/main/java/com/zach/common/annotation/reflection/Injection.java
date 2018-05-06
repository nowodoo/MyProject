package com.zach.common.annotation.reflection;

import javax.annotation.Resource;

/**
 * 注入类，将person注入Injection对象中去
 */
@Resource
public class Injection {

    @SelfAnnotation(name = "Person")
    @Resource(name = "nameValue")
    static Person person;

    public void show() {
        System.out.println(person.getName() + "," + person.getAge());
    }

}  