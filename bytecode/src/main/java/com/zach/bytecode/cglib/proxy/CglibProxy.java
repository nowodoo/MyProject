package com.zach.bytecode.cglib.proxy;

import com.google.inject.internal.cglib.proxy.Enhancer;
import com.google.inject.internal.cglib.proxy.MethodInterceptor;
import com.google.inject.internal.cglib.proxy.MethodProxy;
import com.zach.bytecode.cglib.interf.IAnimal;
import com.zach.bytecode.cglib.pojo.Dog;
import com.zach.bytecode.cglib.pojo.Person;

import java.lang.reflect.Method;
  
public class CglibProxy implements MethodInterceptor {
  
    private Object srcTarget;  
  
    private CglibProxy(Object o) {  
        this.srcTarget = o;  
    }  
  
    @SuppressWarnings("unchecked")  
    public static <T> T proxyTarget(T t) {  
        Enhancer en = new Enhancer();
        en.setSuperclass(t.getClass());  
        en.setCallback(new CglibProxy(t));  
        T tt = (T) en.create();  
        return tt;  
    }  
  
    @Override  
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
  
        Object o = method.invoke(srcTarget, args);  
        return o;  
    }  
  
    public static void main(String[] args) {  
        // 未实现接口的类的代理  
        Person person = CglibProxy.proxyTarget(new Person());
        person.see("apple");
        // 实现接口的类的代理  
        IAnimal dog = CglibProxy.proxyTarget(new Dog());
        dog.see("bread");
    }

}