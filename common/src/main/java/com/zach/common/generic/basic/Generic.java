package com.zach.common.generic.basic;

/**
 * 如果使用object存放所有的数据的话，会存在强转的情况，我们为了避免强转，就使用泛型，
 * 其实就是将数据的类型作为一个参数。
 */
public class Generic {
    private Object[] mData;

    public Generic(int capacity) {
        mData = new Object[capacity];
    }

    public Object getData(int index) {
        return mData[index];
    }

    public void add(int index, Object item) {
        mData[index] = item;
    }
}