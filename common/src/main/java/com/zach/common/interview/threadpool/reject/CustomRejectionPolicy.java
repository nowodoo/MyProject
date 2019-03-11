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
    }
}
