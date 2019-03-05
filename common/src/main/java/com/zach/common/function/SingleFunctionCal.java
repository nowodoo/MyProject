package com.zach.common.function;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-05 16:37
 */
public class SingleFunctionCal {
    public int compute(int a, SingleFunction<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }
}
