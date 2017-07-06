package com.zach.common;

import com.lmax.disruptor.EventFactory;

/**
 * 用來返回longEvent（数据槽）
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    public LongEvent newInstance() {
        return new LongEvent();
    }
}