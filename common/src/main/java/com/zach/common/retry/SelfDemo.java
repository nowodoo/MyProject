package com.zach.common.retry;

public class SelfDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                int result = 0;
                //模拟第 1&2 次出现异常
                if (0 == i) {
                    result = 20 / 0;
                } else if (1 == i) {
                    result = 20 / 0;
                } else {
                    result = 20 / 1;
                }

                System.out.println("获取正确的结果:" + result + "执行次数：" + (i + 1));
                break;
            } catch (Exception e) {
                if (i > 3) {
                    System.out.println("重试超过5次!");
                }
            }
        }
    }
}
