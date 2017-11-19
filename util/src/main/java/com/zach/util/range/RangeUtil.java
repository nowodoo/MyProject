package com.zach.util.range;

import com.google.common.collect.Lists;

import java.util.List;

public class RangeUtil {


    //使用泛型返回一个分段的集合
    public static <T> List<List<T>> getSegments(List<T> list, Integer segmentLength){

        List<List<T>> partition = Lists.partition(list, segmentLength);
        return partition;
    }

}
