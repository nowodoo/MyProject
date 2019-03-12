package com.zach.common.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-12 14:27
 */
public class MainTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 3; i++) {
            threadPool.execute(()->{
                map.computeIfAbsent("key1", key->{
                    System.out.println("begin to set up real value now, only one thread print this sentence !");
                    return "value1";
                });
            });
        }


        System.out.println("result as follows ---> " + map);
        System.out.println("测试computeIfAbsent !");

    }
}
