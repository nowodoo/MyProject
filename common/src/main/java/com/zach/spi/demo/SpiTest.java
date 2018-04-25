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


        while (it.hasNext()) {
            SPIService service = (SPIService) it.next();
            service.spiTest();
        }
    }
}
