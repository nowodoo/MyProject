package com.zach.common.interview.deadlock;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-06 15:05
 */
public class DeadLockTest {
    public static void main(String[] args) {
        final Object lockObject = new Object();
        final Integer a = Integer.valueOf(1);
        final Integer b = Integer.valueOf(2);

        Thread t1 = new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"获取a");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (b) {
                    System.out.println(Thread.currentThread().getName()+"获取b");
                }

            }
        });

        Thread t2 = new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"获取b");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (a) {
                    System.out.println(Thread.currentThread().getName()+"获取a");
                }

            }
        });

        t1.start();
        t2.start();

    }
}
