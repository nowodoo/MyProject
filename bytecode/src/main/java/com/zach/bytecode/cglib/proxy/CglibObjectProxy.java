package com.zach.bytecode.cglib.proxy;

import com.google.inject.internal.cglib.proxy.Enhancer;
import com.google.inject.internal.cglib.proxy.MethodInterceptor;
import com.google.inject.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibObjectProxy {

    @SuppressWarnings("rawtypes")
    public static Object ceateProxtObject(final Object object, Class clazz) {
        // 声明增加类实例  
        Enhancer en = new Enhancer();
        // 设置被代理类字节码，CGLIB根据字节码生成被代理类的子类  
        en.setSuperclass(clazz);
        // 设置回调函数，即一个方法拦截  
        en.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {

                System.out.println("proxy before!");

                // 注意参数object,仍然为外部声明的源对象，且Method为JDK的Method反射  
                Object o = method.invoke(object, args);

                System.out.println("proxy after!");

                return o;
            }
        });
        return en.create();
    }
}