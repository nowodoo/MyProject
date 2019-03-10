package com.zach.common.interview.printeventoddfunction;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-06 16:12
 */
public class PrintEventOddTest {

    public static void main(String[] args) {
        Boolean printOddFlag = false;   //是否在打印偶数
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        final HashMap<String, Object> map = new HashMap<>();
        map.put("lock", lock);
        map.put("condition", condition);
        map.put("condition", condition);
        map.put("flag", printOddFlag);


        Thread t1 = new Thread(() -> {
            int a = 2;

            int i = 0;
            while (i < 100) {
                try {
                    ((ReentrantLock) map.get("lock")).lock();
                    if ((Boolean)map.get("flat")) {
                        map.put("flag", false);
                        System.out.println(Thread.currentThread().getName() + "-偶数" + i);
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

        });


        Thread t2 = new Thread(() -> {
            int a = 2;

            int i = 0;
            while (i < 100) {
                try {
                    ((ReentrantLock) map.get("lock")).lock();
                    if (!printOddFlag) {
                        map.put("flag", true);
                        System.out.println(Thread.currentThread().getName() + "-奇数" + i);
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


        });


        t1.start();
        t2.start();
    }
}
