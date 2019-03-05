package com.zach.common.function;

@FunctionalInterface
public interface SingleFunction<T, R> {
    R apply(T t);
}
