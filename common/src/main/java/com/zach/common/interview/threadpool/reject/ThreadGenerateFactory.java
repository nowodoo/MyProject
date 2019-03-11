package com.zach.common.interview.threadpool.reject;

import java.util.concurrent.ThreadFactory;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-11 11:27
 */
public class ThreadGenerateFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        //最关键的一步, 这里要放入任务的.
        return new Thread(r);
    }
}
