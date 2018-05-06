package com.zach.tool.aes;

public class StringUtils {

    public static boolean isEmpty(String base64Code) {
        boolean result = false;
        if (null == base64Code || (null != base64Code && "".equals(base64Code))) {
            result = true;
        }
        return result;
    }
}
