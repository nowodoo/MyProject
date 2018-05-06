package com.zach.tool.aes;

import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * 加密： java -jar ***.jar 1 key 123
 * 解密： java -jar ***.jar 2 key dsfhdsfhds
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        args = new String[]{"2", "iloveshell", "ag0bgZP/KW/0FVTxOFfCcA=="};
        execute(args);
    }

    private static void execute(String[] args) {
        if (null != args && args.length != 0) {
            try {
                String type = args[0];
                String key = args[1];
                String content = args[2];


                if ("1".equals(type)) {
                    String s = AESUtils.aesEncrypt(content, key);
                    System.out.println(s);
                } else if ("2".equals(type)) {
                    String s = AESUtils.aesDecrypt(content, key);
                    System.out.println(s);
                } else {
                    System.out.println("args[0] should be 0 or 1!, 0:encode, 1 decode");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("please input the args");
        }
    }

}
