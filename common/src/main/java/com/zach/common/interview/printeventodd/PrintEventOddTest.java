package com.zach.common.interview.printeventodd;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-06 16:12
 */
public class PrintEventOddTest {
    public static boolean flag = false;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        HashMap<String, Object> map = new HashMap<>();
        map.put("lock", lock);
        map.put("condition", condition);


        Thread t1 = new Thread(new Producer(map));
        Thread t2 = new Thread(new Consumer(map));
        t1.start();
        t2.start();
    }
}
