package com.zach.common.util;

import com.alibaba.fastjson.serializer.NameFilter;

/**
 * @author wanqin
 * 时间: 2019/11/13.
 * 相关业务:
 */
public class HumpNameFilter implements NameFilter {
    @Override
    public String process(Object object, String name, Object value) {
        //名字转换为驼峰.
        return NameTool.lineToHump(name);
    }
}
