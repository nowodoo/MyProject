package com.zach.common.function;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-05 16:33
 */
public class TestClass {
    public static void main(String[] args) {

        //最简答的函数使用
        SingleFunctionCal singleFunctionCal = new SingleFunctionCal();
        int result = singleFunctionCal.compute(5, value -> value * value);
        System.out.println(result);



    }
}
