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


        System.out.println("开始使用directByteBuffer !");

        //directByteBuffer
        ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(100);
        directByteBuffer.put("himan".getBytes());
        directByteBuffer.flip();
        //读取
        for (int i = 0; i < 100; i++) {
            int limit = directByteBuffer.limit();
            if (i < limit) {
                byte r = directByteBuffer.get();
                System.out.println((char)r);
            }
        }
        //按照偏移量读取.
        directByteBuffer.flip();
        byte[] dst = "100000000".getBytes();
        ByteBuffer byteBuffer1 = directByteBuffer.get(dst, 1, 3);
        byte b = byteBuffer1.get();
        System.out.println("结果是: " + (char) b);
        System.out.println("目标数组结果是: " + new String(dst));  //输出结果:   目标数组结果是: 1him00000


    }
}
