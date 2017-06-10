package com.zach.common;


import com.lmax.disruptor.EventHandler;

/**
 * 类似于消费者（负责消息的处理）
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    //收到事件，进行数据的处理
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        //收到事件
        System.out.println("onEvent---Event: " + event + "," + sequence + "," + event.getVaule());

    }
}