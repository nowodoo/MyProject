package com.zach.util.range;

import java.net.URISyntaxException;

public class PathUtil {
    //相对路径获取绝对路径
    public static String getAbsPath(String relativePath) throws URISyntaxException {
        String path = PathUtil.class.getResource(relativePath).toURI().getPath();
        return path;
    }

    public static void main(String[] args) throws URISyntaxException {
        getAbsPath("/datax/plugin/");
    }
}
