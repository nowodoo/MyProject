package com.zach.common.generic.basic;

import org.testng.annotations.Test;

/**
 * Created by zach on 17/6/11.
 */
public class GenericMethodTest {

    @Test
    public void test() {
        GenericMethod genericMethod = new GenericMethod();
        String result = genericMethod.ifThenElse(false, "1", "2");
        System.out.println(result);
    }
}
