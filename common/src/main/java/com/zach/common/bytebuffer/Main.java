package com.zach.common.bytebuffer;

import java.nio.ByteBuffer;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-02-18 11:53
 */
public class Main {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.put("hello".getBytes());


        //转换读写模式.
        byteBuffer.flip();


        for (int i = 0; i < 100; i++) {
            int limit = byteBuffer.limit();
            if (i < limit) {
                byte b = byteBuffer.get();
                System.out.println((char)b);
            }
        }
    }
}
