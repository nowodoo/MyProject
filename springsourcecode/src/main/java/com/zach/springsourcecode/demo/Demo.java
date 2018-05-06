package com.zach.springsourcecode.demo;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Demo {
    public static void main(String[] args) {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Object test = bf.getBean("test");

    }
}
