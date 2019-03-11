package com.zach.common.interview.threadpool.reject;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-11 11:26
 */
public class CustomRejectionPolicy implements RejectedExecutionHandler {

    /**
     * 在这里获取被拒绝的信息.
     * @param r
     * @param executor
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("拒绝策略, 线程信息 ----> " + r.toString());
        //这里可以将任务放在redis或者rocketMQ或者其他的什么地方.来异步处理拒绝的消息. 看业务是不是有对应的需要.


        //https://examples.javacodegeeks.com/core-java/util/concurrent/rejectedexecutionhandler/java-util-concurrent-rejectedexecutionhandler-example/
        //上面的url是一个例子,使用的是另一个线程池进行处理.
    }
}
