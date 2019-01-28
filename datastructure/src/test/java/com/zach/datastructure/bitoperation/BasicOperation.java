package com.zach.datastructure.bitoperation;

import org.junit.Test;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-01-28 14:16
 */
public class BasicOperation {
    @Test
    public void test() {
        Integer[] array = new Integer[10];

        System.out.println("开始输出语句:");
        //打印初始化语句
        for (int i = 0; i < 10; i++) {
            System.out.println("array[" + i + "] = " + (i * 2) + ";");
        }


        //数据初始化
        array[0] = 2;
        array[1] = 4;
        array[2] = 6;
        array[3] = 8;
        array[4] = 10;
        array[5] = 12;
        array[6] = 14;
        array[7] = 16;
        array[8] = 18;
        array[9] = 7;


        System.out.println("");
        System.out.println("开始输出二进制:");
        //获取每个数的二进制(使用32位补齐)
        for (int i = 0; i < 10; i++) {
            String s = Integer.toBinaryString(array[i]);
            int total = 32;
            int leftLength = 32 - s.length();
            String appendStr = "";
            for (int j = 0; j < leftLength; j++) {
                appendStr += "0";
            }

            System.out.println(appendStr + s);
        }

        //将所有的值进行异或
        Integer eo = 0;
        Integer result = 0;
        for (int i = 0; i < 10; i++) {
            result = eo ^ array[i];
        }


        System.out.println("");
        System.out.println("所有的结果异或之后:");
        //所有的结果异或
        System.out.println(result);
    }
}
