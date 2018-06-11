package com.zach.common.io;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get("/Users/zach/logs/coupon-service/coupon-service.log");
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);


        List<String> result = lines.filter(item -> {
            if (null != item && item.indexOf("242") != -1) {
                return true;
            }else {
                return false;
            }

        }).collect(Collectors.toList());

        System.out.println(result);
    }
}
