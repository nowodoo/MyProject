package com.zach.bytecode.cglib.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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


                // 中间利用反射调用实际的方法,这个方法可以取到方法的参数.
                // 注意参数object,仍然为外部声明的源对象，且Method为JDK的Method反射  
                Object o = method.invoke(object, args);



                System.out.println("proxy after!");
                return o;
            }
        });
        return en.create();
    }
}