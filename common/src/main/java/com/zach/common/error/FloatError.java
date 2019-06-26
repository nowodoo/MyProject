package com.zach.common.error;

/**
 * @author wanqin
 * 时间: 2019-06-19.
 * 相关业务:
 */
public class FloatError {
    /**
     * float的错误.
     * @param args
     */
    public static void main(String[] args) {
        float g = 0.7f - 0.6f;
        float h = 0.8f - 0.7f;

        System.out.println(g);
        System.out.println(h);
        System.out.println(g == h);
    }
}
