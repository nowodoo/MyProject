package com.zach.common.interview.produceconsume;

import java.util.concurrent.ConcurrentLinkedQueue;

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
        Thread consumer = new Thread(new Consumer(lockObject, queue));

        producer.start();
        consumer.start();
    }
}
