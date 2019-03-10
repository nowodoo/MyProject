package com.zach.common.interview.threadpool;

import java.util.concurrent.CountDownLatch;

public class TestClass{
	public static void main(String[] args){
        final CountDownLatch latch = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                System.out.println("前序线程执行");
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
            System.out.println("最后线程执行完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}