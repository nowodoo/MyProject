package com.zach.common;

import org.testng.annotations.Test;

/**
 * Created by zach on 17/6/3.
 */
public class TestCase {
    @Test
    public void test() {
        System.out.println(System.nanoTime());
    }

    @Test
    public void testCount() {
        long ITERATIONS = 500L * 1000L * 1000L;

        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println(--ITERATIONS);
        }
    }

}
