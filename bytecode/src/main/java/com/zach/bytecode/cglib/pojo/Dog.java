package com.zach.bytecode.cglib.pojo;

import com.zach.bytecode.cglib.interf.IAnimal;

public class Dog implements IAnimal {
    @Override
    public Object see(String see) {
        System.out.println("dog see:" + see);
        return null;
    }
}
