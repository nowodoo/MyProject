package com.zach;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int verticalRowNum = 101;
        int horizontallRowNum = 100;

        //坐标转换
        Point point = new Point(3, 5);
        Point point1 = new Point(4, 5);
        ArrayList<Point> points = new ArrayList<Point>();



        for (int i = 0; i < 10000; i++) {
            Object parse = JSON.parse("[(33,87), (31,86), (30,86), (38,91), (37,89), (38,90), (39,90), (41,91), (42,91), (43,91), (44,91), (44,90), (43,90), (41,89), (41,88), (41,87), (41,86), (41,85), (41,84), (41,83), (40,84)]");
            System.out.println(parse);
        }


        //表示行
        for (int i = 0; i < verticalRowNum; i++) {
            //表示列
            for (int j = 0; j < horizontallRowNum; j++) {
                int x = j;
                int y = verticalRowNum - i - 1;
                if (points.contains(new Point(x, y))) {
                    System.out.print("+");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
