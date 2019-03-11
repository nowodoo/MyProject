package com.zach.common.interview.threadpool.reject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-11 11:11
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = null;

        try {
            //定义线程池需要的组件和变量
            int corePoolSize = 2;  //核心线程数
            int maxPoolSize = 5;  //最大线程数
            int keepAliveTime = 30;  //线程的回收时间
            BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);


            //initialize thread pool, 关于等待时间的说明, 就是空闲线程等待新任务结束的最大时间.    the maximum time that excess idle threads will wait for new tasks before terminating.
            pool = new ThreadPoolExecutor(
                    corePoolSize,
                    maxPoolSize,
                    keepAliveTime,
                    TimeUnit.MINUTES,
                    blockingQueue);
            //set up rejection strategy.
            pool.setRejectedExecutionHandler(new RejectionPolicy());
            //set up thread factory
            pool.setThreadFactory(new ThreadGenerateFactory());


            //开始执行任务
            for (int i = 0; i < 200; i++) {
                pool.execute(new MyTask());
            }

            System.out.println("主线程执行完成!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //清理资源
            if (null != pool) {
                pool.shutdown();
            }
        }
    }
}
