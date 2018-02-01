package com.zach.common.retry;

public class SelfDemo {

    public static void main(String[] args) {
        int tryTimes = 10;
        for (int tryCount = 0; tryCount < tryTimes; tryCount++) {
            try {
                int result = 0;
                //模拟第 1&2 次出现异常
                if (0 == tryCount) {
                    result = 20 / 0;
                } else if (1 == tryCount) {
                    result = 20 / 0;
                } else if (2== tryCount) {
                    result = 20 / 0;
                } else if (3 == tryCount) {
                    result = 20 / 0;
                } else if (4 == tryCount) {
                    result = 20 / 0;
                } else if (5 == tryCount) {
                    result = 20 / 0;
                } else if (6 == tryCount) {
                    result = 20 / 0;
                } else if (7 == tryCount) {
                    result = 20 / 0;
                } else if (8 == tryCount) {
                    result = 20 / 0;
                } else if (9 == tryCount) {
                    result = 20 / 0;
                } else if (10 == tryCount) {
                    result = 20 / 0;
                } else {
                    result = 20 / 1;
                }

                break;
            } catch (Exception e) {
                //出现异常了就休息一下
                try {
                    Thread.sleep(1000);
                } catch (Exception e1) {
                    System.out.println("重试超过" + tryTimes + "次");
                }

                //超时出现10次直接退出就好了
                if (tryCount > tryTimes - 2) {
                    System.out.println("重试超过" + tryTimes + "次");
                    throw new RuntimeException("重试超过" + tryTimes + "次");
                }
            }
        }
    }
}
