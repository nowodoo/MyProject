package com.zach.multithread.futuretask;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int time;
    public MyCallable(int time) {
        this.time = time;
    }

    @Override
    public String call() throws Exception {
        System.out.println(time);
        return null;
    }
}
