package com.zach.common.version;

public class DemoExecutor {
    public static void main(String[] args) {
        VersionInterface version1Interface = new VersionV1();
        System.out.println(version1Interface.methodOne());


        VersionInterface version2Interface = new VersionV2();
        System.out.println(version2Interface.methodTwo());


        VersionInterface version3Interface = new VersionV3();
        System.out.println(version3Interface.methodThree());
        System.out.println(version3Interface.methodOne());
    }
}
