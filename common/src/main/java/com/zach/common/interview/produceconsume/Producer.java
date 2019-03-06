package com.zach.common.interview.produceconsume;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-06 15:14
 */
public class Producer implements Runnable {
    Object lockObject;
    ConcurrentLinkedQueue<String> queue;


    public Producer(Object lockObject, ConcurrentLinkedQueue<String> queue) {
        this.lockObject = lockObject;
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (lockObject) {
                boolean offer = queue.offer("1");
                System.out.println("生产者添加元素,结果:" + offer);

                lockObject.notifyAll();

                if (1 == 2) {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
