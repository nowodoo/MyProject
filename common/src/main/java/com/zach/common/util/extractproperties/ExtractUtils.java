package com.zach.common.util.extractproperties;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wanqin
 * 时间: 2019-06-07.
 * 相关业务:
 */
public class ExtractUtils {
    public static Map<String, Class> extractProperties(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        TreeMap<String, Class> result = new TreeMap<>();

        for (Field f : fields) {
            f.setAccessible(true); // 设置些属性是可以访问的
            String name = f.getName(); // 得到此属性的名称
            result.put(name, f.getType());
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Class> result = extractProperties(TreeMap.class);
        System.out.println(JSON.toJSON(result));
    }
}
