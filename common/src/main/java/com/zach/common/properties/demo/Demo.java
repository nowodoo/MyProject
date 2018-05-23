package com.zach.common.properties.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) {
        try {
            try {
                String filePath = "/Users/zach/Workspace/code/idea/dwd/dwd-recharge-service/recharge-gw-service-server/src/main/resources/config/application-try.properties";
                Properties properties = PropertiesUtils.readProperties(filePath);
            } catch (Exception e) {
            }


            for (int i = 0; i < 2; i++) {
                System.out.println("\r\n");
            }
            System.out.println("#开发环境");


            /**
             * dev环境
             */
            Map<String, String> devZkValues = new HashMap<>();
            devZkValues.put("dubbo.base.zk", "192.168.11.29:2285?backup=192.168.11.32:2285,192.168.11.20:2285");
            devZkValues.put("dubbo.gw.zk", "192.168.11.29:2281?backup=192.168.11.32:2281,192.168.11.20:2281");
            devZkValues.put("dubbo.common.zk", "192.168.11.29:2185?backup=192.168.11.32:2185,192.168.11.20:2185");
            devZkValues.put("dubbo.unit.zk", "192.168.11.29:2181?backup=192.168.11.32:2181,192.168.11.20:2181");
            for (Map.Entry<String, String> item : devZkValues.entrySet()) {
                System.out.println(item.getKey() + "=" + item.getValue());
            }


            for (int i = 0; i < 2; i++) {
                System.out.println("\r\n");
            }
            System.out.println("#测试环境");

            
            /**
             * 测试环境
             */
            Map<String, String> testZkValues = new HashMap<>();
            testZkValues.put("dubbo.base.zk", "10.0.0.10:2285?backup=10.0.0.17:2285,10.0.0.5:2285");
            testZkValues.put("dubbo.gw.zk", "10.0.0.10:2281?backup=10.0.0.17:2281,10.0.0.5:2281");
            testZkValues.put("dubbo.common.zk", "10.0.0.10:2185?backup=10.0.0.17:2185,10.0.0.5:2185");
            testZkValues.put("dubbo.unit.zk", "10.0.0.10:2181?backup=10.0.0.17:2181,10.0.0.5:2181");
            for (Map.Entry<String, String> item : testZkValues.entrySet()) {
                System.out.println(item.getKey() + "=" + item.getValue());
            }

            for (int i = 0; i < 2; i++) {
                System.out.println("\r\n");
            }
            System.out.println("#灰发环境");


            /**
             * 灰发环境
             */
            Map<String, String> preZkValues = new HashMap<>();
            preZkValues.put("dubbo.base.zk", "172.24.1.11:2481?backup=172.24.1.12:2481,172.24.1.13:2481");
            preZkValues.put("dubbo.gw.zk", "172.24.1.11:2381?backup=172.24.1.12:2381,172.24.1.13:2381");
            preZkValues.put("dubbo.common.zk", "72.24.0.6:2185?backup=172.24.0.7:2185,172.24.0.8:2185");     //这是线上的
            preZkValues.put("dubbo.unit.zk", "172.24.0.6:2186?backup=172.24.0.7:2186,172.24.0.8:2186");
            for (Map.Entry<String, String> item : preZkValues.entrySet()) {
                System.out.println(item.getKey() + "=" + item.getValue());
            }


            for (int i = 0; i < 2; i++) {
                System.out.println("\r\n");
            }
            System.out.println("#线上环境");


            /**
             * 线上环境
             */
            Map<String, String> onlineZkValues = new HashMap<>();
            onlineZkValues.put("dubbo.base.zk", "172.24.1.11:2281?backup=172.24.1.12:2281,172.24.1.13:2281");
            onlineZkValues.put("dubbo.gw.zk", "172.24.1.11:2181?backup=172.24.1.12:2181,172.24.1.13:2181");
            onlineZkValues.put("dubbo.common.zk", "172.24.0.6:2185?backup=172.24.0.7:2185,172.24.0.8:2185");
            onlineZkValues.put("dubbo.unit.zk", "172.24.0.6:2181?backup=172.24.0.7:2181,172.24.0.8:2181");
            for (Map.Entry<String, String> item : onlineZkValues.entrySet()) {
                System.out.println(item.getKey() + "=" + item.getValue());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
