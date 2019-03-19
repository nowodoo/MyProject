package com.zach.common.optional;

import java.util.Optional;

/**
 * @author Zach Ma
 * @description:
 * @create 2019-03-19 10:48
 */
public class TestMain {
    public static void main(String[] args) {

        //or Else Get Test
        Optional<Object> o = Optional.ofNullable(null);

        Object o1 = o.orElseGet(() -> {
            return "test value";
        });
        System.out.println(o1);


        //flatMap test
        Optional<AppleTree> appleTree = Optional.ofNullable(new AppleTree());
        Optional<Apple> apple = Optional.ofNullable(new Apple());
        Optional<String> s = appleTree.flatMap(p -> apple.map(a -> {
            System.out.println("非空时候开始执行!");
            return p.getName() + "-" + a.getName();
        }));

        String s1 = s.orElse("基础默认值!");
        String s2 = s.orElseGet(() -> {
            return "函数默认值";
        });


        System.out.println(s1);
        System.out.println(s2);

    }
}
