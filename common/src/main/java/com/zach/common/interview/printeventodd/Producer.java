package com.zach.common.interview.printeventodd;

import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-06 16:13
 */
public class Producer implements Runnable {

    Map<String, Object> map;

    public Producer(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int a = 2;
        int i = 1;
        while (i < 100) {
            try {
                ((ReentrantLock) map.get("lock")).lock();
                if (PrintEventOddTest.flag) {
                    System.out.println(Thread.currentThread().getName() + "-奇数" + i);
                    PrintEventOddTest.flag = false;
                    i += 2;
                    ((Condition) map.get("condition")).signal();
                } else {
                    ((Condition) map.get("condition")).await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ((ReentrantLock) map.get("lock")).unlock();
            }
        }

    }
}
