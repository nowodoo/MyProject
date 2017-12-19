package com.zach.common.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        String source = "dsjhfkds123jkhjkh";

        Pattern p = Pattern.compile("123");
        Matcher m = p.matcher(source);


        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
