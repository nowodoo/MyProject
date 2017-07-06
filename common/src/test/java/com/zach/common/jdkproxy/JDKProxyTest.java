package com.zach.common.jdkproxy;


import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class JDKProxyTest {


    @Test
    public void test() throws Exception{
        //这里有两种写法，我们采用略微复杂的一种写法，这样更有助于大家理解。
//        Class<?> proxyClass= Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(),HelloWorld.class);
//        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
//        final InvocationHandler ih = new MyInvocationHandler(new HelloworldImpl());
//        HelloWorld helloWorld= (HelloWorld)cons.newInstance(ih);
//        helloWorld.sayHello();

        //下面是更简单的一种写法，本质上和上面是一样的
        HelloWorld helloWorld=(HelloWorld)Proxy.
                 newProxyInstance(JDKProxyTest.class.getClassLoader(),
                        new Class<?>[]{HelloWorld.class},
                        new MyInvocationHandler(new HelloworldImpl()));
        helloWorld.sayHello();


    }
}