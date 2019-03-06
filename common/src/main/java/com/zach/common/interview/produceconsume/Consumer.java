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
            while (true) {
                synchronized (lockObject) {
                    String poll = queue.poll();
                    if (null == poll) {
                        lockObject.wait();
                    }else{
                        System.out.println("消费者取出的数据:" + poll);
                    }

                }

                if (1 == 2) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
