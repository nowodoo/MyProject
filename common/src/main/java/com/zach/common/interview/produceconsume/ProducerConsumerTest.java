package com.zach.common.interview.produceconsume;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-06 15:13
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Object lockObject = new Object();
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(new Producer(lockObject, queue));

        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            threadPool.execute(new Thread(new Consumer(lockObject, queue)));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.start();
    }
}
