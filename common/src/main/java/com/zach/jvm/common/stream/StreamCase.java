package com.zach.jvm.common.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamCase {
    public static void main(String[] args) {

        //how to use filter
        List<Integer> l = IntStream.range(1,10)
                .filter( i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(l); //[2, 4, 6, 8]
    }
}
