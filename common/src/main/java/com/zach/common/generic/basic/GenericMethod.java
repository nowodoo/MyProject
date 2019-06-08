package com.zach.common.generic.basic;

/**
 * Created by zach on 17/6/11.
 */
public class GenericMethod {
    /**
     * 使用泛型方法首先需要在返回值前面声明泛型类型。
     * @param b
     * @param first
     * @param second
     * @param <T>
     * @returnS
     */
    public <T, R, S> R ifThenElse(boolean b, T first, R second, S third) {
        return second;
    }
}
