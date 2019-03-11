package com.zach.common.interview.threadpool.reject;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-11 15:29
 */
public class CustomTask implements Runnable{
    @Override
    public void run() {
        System.out.println("执行自定义任务!");
    }
}
