package com.zach.common.generic.basic;

import org.testng.annotations.Test;

/**
 * Created by zach on 17/6/11.
 */
public class GenericMethodTest {

    /**
     * 测试泛型方法
     */
    @Test
    public void testGenericMethod() {
        GenericMethod genericMethod = new GenericMethod();
        String result = genericMethod.ifThenElse(false, "1", "2");
        System.out.println(result);
    }
}
