package com.zach.common.function;

import java.util.Objects;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-05 16:44
 */
public interface ComposeFunction<T, R> {
    default <V> ComposeFunction<V, R> compose(ComposeFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    R apply(T t);
}
