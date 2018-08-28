package com.zach.dubboprovider.akka.demo;

import java.io.Serializable;

/**
 * 打招呼的人(就是用来发送消息的)
 * @author SUN
 * @version 1.0
 * @Date 16/1/6 21:41
 */
public class WhoToGreet implements Serializable {
    private static final long serialVersionUID = -17161686845552068L;

    public final String who;
    public WhoToGreet(String who) {
        this.who = who;
    }
}