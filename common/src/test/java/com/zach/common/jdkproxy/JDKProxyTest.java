package com.zach.common.jdkproxy;


import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class JDKProxyTest {


    @Test
    public void test() throws Exception{

        //下面是更简单的一种写法，本质上和上面是一样的
        HelloWorld helloWorld=(HelloWorld)Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), new Class<?>[]{HelloWorld.class}, new MyInvocationHandler(new HelloworldImpl()));
        helloWorld.sayHello();


    }
}