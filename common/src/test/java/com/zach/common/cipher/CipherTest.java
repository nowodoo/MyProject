package com.zach.common.cipher;

import org.testng.annotations.Test;

import java.util.Base64;
import java.util.Map;

/**
 * Created by zach on 17/7/5.
 */
public class CipherTest {
    @Test
    public void test() throws Exception {
        String str = "hello zach";
        byte[] bytes = str.getBytes();

        System.out.println("result:");
        System.out.println(Coder.encryptBASE64(bytes));
    }

    @Test
    public void test1() throws Exception {
        byte[] bytes = Coder.decryptBASE64("aGVsbG8gemFjaA==");
        String result = new String(bytes);

        System.out.println("result:");
        System.out.println(result);
    }

    @Test
    public void test2() throws Exception {
        String str = "hello zach";
        byte[] bytes = str.getBytes("UTF-8");

        byte[] resultByte = Coder.encryptMD5(bytes);
        String resultStr = new String(resultByte);

        System.out.println(resultStr);
    }

    @Test
    public void test3() throws Exception {
        String str = "hello zach";
        byte[] bytes = str.getBytes("UTF-8");

        byte[] resultByte = Coder.encryptSHA(bytes);
        String resultStr = new String(resultByte);

        System.out.println(resultStr);
    }


    /**
     * 初始化公钥和私钥，从map里面获取需要的公钥和私钥
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {

        Map<String, Object> resultMap = Coder.initKey();

        String privateKey = Coder.getPrivateKey(resultMap);
        String publicKey = Coder.getPublicKey(resultMap);

        System.out.println(privateKey);
        System.out.println(publicKey);
    }


    /**
     * 使用私钥加密、公钥解密
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {

        //获取公钥和私钥
        Map<String, Object> resultMap = Coder.initKey();
        String privateKey = Coder.getPrivateKey(resultMap);
        String publicKey = Coder.getPublicKey(resultMap);


        //模拟数据
        String inuptStr = "data";
        byte[] data = inuptStr.getBytes();

        //使用私钥加密、公钥解密
        byte[] encryptResultByte = Coder.encryptByPrivateKey(data, privateKey);
        byte[] decryptResultByte = Coder.decryptByPublicKey(encryptResultByte, publicKey);

        String decryptResultStr = new String(decryptResultByte);
        System.out.println(decryptResultStr);
    }


    //公钥加密，私钥解密
    @Test
    public void test6() throws Exception {
        //获取公钥和私钥
        Map<String, Object> resultMap = Coder.initKey();
        String privateKey = Coder.getPrivateKey(resultMap);
        String publicKey = Coder.getPublicKey(resultMap);


        //模拟数据
        String inuptStr = "data1";
        byte[] data = inuptStr.getBytes();

        //使用私钥加密、公钥解密
        byte[] encryptResultByte = Coder.encryptByPublicKey(data, publicKey);
        byte[] decryptResultByte = Coder.decryptByPrivateKey(encryptResultByte, privateKey);

        String decryptResultStr = new String(decryptResultByte);
        System.out.println(decryptResultStr);

    }
}
