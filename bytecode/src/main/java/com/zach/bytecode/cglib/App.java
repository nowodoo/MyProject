package com.zach.bytecode.cglib;

import com.zach.bytecode.cglib.interf.IAnimal;
import com.zach.bytecode.cglib.pojo.Dog;
import com.zach.bytecode.cglib.pojo.Person;
import com.zach.bytecode.cglib.proxy.CglibObjectProxy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //  未实现接口的类的代理
        Person proxyPerson = (Person) CglibObjectProxy.ceateProxtObject(new Person(), Person.class);
        proxyPerson.see("apple");


        // 实现接口的类的代理
        IAnimal proxyDog = (IAnimal) CglibObjectProxy.ceateProxtObject(new Dog(), Dog.class);
        proxyDog.see("bread");

    }
}
