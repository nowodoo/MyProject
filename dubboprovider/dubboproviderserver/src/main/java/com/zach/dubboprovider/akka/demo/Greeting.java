package com.zach.dubboprovider.akka.demo;

import java.io.Serializable;

/**
 * 招呼体,里面有打的什么招呼(表示消息的内容)
 * @author SUN
 * @version 1.0
 * @Date 16/1/6 21:44
 */
public class Greeting implements Serializable {
    public final String message;
    public Greeting(String message) {
        this.message = message;
    }
}