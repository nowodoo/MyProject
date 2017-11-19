package com.zach.util.range;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
}
