package com.zach.common.interview.produceconsume;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-06 15:14
 */
public class Consumer implements Runnable {
    Object lockObject;
    ConcurrentLinkedQueue<String> queue;

    public Consumer(Object lockObject, ConcurrentLinkedQueue<String> queue) {
        this.lockObject = lockObject;
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            //使用布隆过滤
            if (!BloomFilter.filter(1)) {
                System.out.println("布隆过滤器生效!");
                return;
            }

            synchronized (lockObject) {
                String poll = queue.peek();
                if (null == poll) {
                    System.out.println("消费者开始等待!");
                    lockObject.wait();
                    String second = queue.peek();
                    System.out.println("消费者取出的数据:" + second);
                } else {
                    System.out.println("消费者取出的数据:" + poll);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
