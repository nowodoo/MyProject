package com.zach.common.generic.basic;

/**
 * 泛型接口
 * 泛型接口最常用的就是用作策略模式的公共策略，比如 Comparator<T> 这个就是定义了一个公共的比较策略。
 * 需要在运行时传入不同的实现类。实现具体的策略。
 * @param <T>
 */
public interface GenericInterface<T> {
    void doSomething(T t);
}