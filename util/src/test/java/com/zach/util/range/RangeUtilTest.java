package com.zach.util.range;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RangeUtilTest {

    @Test
    public void test1() {
        ArrayList<Integer> strings = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            strings.add(i);
        }
        int length = 10;

        List<List<Integer>> segmemts = RangeUtil.getSegments(strings, length);
        System.out.println("hello");
    }

    @Test
    public void test2() {
        List<Map<String, Long>> segments = RangeUtil.getSegments(100L, 88);
        System.out.println(segments);
    }

    @Test
    public void test3() {


    }
}
