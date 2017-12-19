package com.zach.common.annotation.reflection;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectionTest {
    /**
     * 获取一个类的所有属性
     */
    @Test
    private void testGetValue(){

        Person propertiesUtil = new Person();
        Field[] declaredFields = propertiesUtil.getClass().getDeclaredFields();

        Map<String, String> resultMap = new HashMap<String, String>();

        for (int i = 0; i < declaredFields.length; i++) {
            String key = declaredFields[i].getName();
            Object value = null;
            try {
                value = declaredFields[i].get(propertiesUtil);
            } catch (IllegalAccessException e) {
                //
                System.out.println("解析出错!");
            }
            resultMap.put(key, value.toString());
        }
        JSON.toJSONString(resultMap);
    }
}
