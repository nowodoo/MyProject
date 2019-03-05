package com.zach.common.function;

import java.util.function.Function;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-05 16:47
 */
public class ComposeFunctionCal {
    public int compute(int a, ComposeFunction<Integer, Integer> function1, ComposeFunction<Integer, Integer> function2) {
        int result = function1.compose(function2).apply(a);
        return result;
    }
}
