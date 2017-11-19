package com.zach.util.range;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeUtil {


    //使用泛型返回一个分段的集合
    public static <T> List<List<T>> getSegments(List<T> list, Integer segmentLength){

        List<List<T>> partition = Lists.partition(list, segmentLength);
        return partition;
    }

    //使用泛型返回一个分段的集合
    public static List<Map<String, Long>> getSegments(Long totalLength, Integer segmentLength){
        List<Map<String, Long>> result = new ArrayList<Map<String, Long>>();
        long start = 0;
        long end = 0;
        int count = 1;
        while ((start = ((1 == count) ? start : start + segmentLength)) < totalLength) {
            count++;
            Map<String, Long> segment = new HashMap<String, Long>();
            segment.put("start", start);
            end = start + segmentLength - 1; //因为会算本身，所以不用的
            segment.put("end", end);
            segment.put("limit", Long.valueOf(segmentLength));
            result.add(segment);

            //放完之后,再检查
            if (start + segmentLength > totalLength) {
                break;
            }
        }
        return result;
    }

}
