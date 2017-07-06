package com.zach.common;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 用来启动的主类
 */
public class LongEventMain {
    public static void main(String[] args) throws Exception {
        // Executor that will be used to construct new threads for consumers
        Executor executor = Executors.newCachedThreadPool();

        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        //ringBuffer的大小，必须的2的倍数
        int bufferSize = 1024;

        //初始话创建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, executor);

        //事件处理器，处理生产者消息  LongEventHandler
        disruptor.handleEventsWith(new LongEventHandler());

        //开启所有的工作线程，自己开启的线程池
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //创建生产者，在这里已经将数据传给了生产者（LongEventProductor）
        LongEventProducer producer = new LongEventProducer(ringBuffer);

        //模拟生产数据
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            //往数据槽中放数据
            bb.putLong(0, l);

            //生产者发送数据，这里bb传递的就是真实的数据，需要被包装的原生的数据。
            producer.onData(bb);
            Thread.sleep(100);
        }
    }
}