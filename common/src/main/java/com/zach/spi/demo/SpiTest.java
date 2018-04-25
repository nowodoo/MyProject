package com.zach.spi.demo;

import sun.misc.Service;

import java.util.Iterator;

public class SpiTest {

    /**
     * @param args
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Iterator it = Service.providers(SPIService.class);


        //找到 meta-inf下面service的文件    文件名字是接口的名字  里面的类是接口的实现
        while (it.hasNext()) {
            SPIService service = (SPIService) it.next();
            service.spiTest();
        }
    }
}
