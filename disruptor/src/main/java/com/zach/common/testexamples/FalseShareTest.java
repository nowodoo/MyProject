package com.zach.common.testexamples;

public class FalseShareTest implements Runnable {

    //定义标识常量
    public static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    private static VolatileLong[] longs;
    public static long SUM_TIME = 0l;

    //构造函数
    public FalseShareTest(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    //主线程调用
    private static void runTest() throws InterruptedException {
        //初始化所有线程数组
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseShareTest(i));
        }

        //启动所有线程数组
        for (Thread t : threads) {
            t.start();
        }
        //join所有的线程数组，将所有的其他的线程的动作放到主线程中来。
        for (Thread t : threads) {
            t.join();
        }
    }

    //实际运行的方法
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }


    //只是定义了一个数据结构，不参数运行流程
    //其中的数据是直接存在主存中的
    public final static class VolatileLong {
        public volatile long value = 0L;
        public long p1, p2, p3, p4, p5, p6;     //屏蔽此行
    }


    public static void main(final String[] args) throws Exception {
        //睡眠10秒
        Thread.sleep(10000);

        for(int j=0; j<10; j++){

            System.out.println(j);
            //接受外部参数变量
            if (args.length == 1) {
                //默认启动4个线程
                NUM_THREADS = Integer.parseInt("4");
            }
            //此数组是放在主存中的
            longs = new VolatileLong[NUM_THREADS]; //每个数组都有自己的主存数据
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }


            //开始启动程序
            final long start = System.nanoTime();
            runTest();
            final long end = System.nanoTime();
            SUM_TIME += end - start;
        }

        System.out.println("平均耗时："+SUM_TIME/10);
    }
}