package com.zach.common;

/**
 * 数据的传输不是直接传递，而是经过这个类的封装，这个就是数据槽。
 */
public class LongEvent {
    private long value;

    public void set(long value) {
        this.value = value;
    }

    public long getVaule() {
        return value;
    }
}