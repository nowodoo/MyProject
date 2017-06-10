package com.zach.common;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * 生产者类,数据来自一个ByteBuffer
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 首先使用ringBuffer获取一个接受参数的序号（sequence），然后封装好了一个longEvent事件,事件的发布是用ringBuffer的
     * publish方法，实际在操作的是ringBuffer，数据的封装是用的LongEvent（数据槽）
     *
     * @param bb
     */
    public void onData(ByteBuffer bb) {
        long sequence = ringBuffer.next();  //获取下一个序号

        try {
            LongEvent event = ringBuffer.get(sequence); // 在disruptor中获取数据的入口
            event.set(bb.getLong(0));  //进行数据填充
        } finally {
            ringBuffer.publish(sequence);  //发布事件，通知消费者
        }
    }
}