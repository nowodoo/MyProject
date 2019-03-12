package com.zach.common.classloader;

public class Client {

    /**
     * 其主要思路整理,就是加载BusService这个类. and then call BusService inside Server.
     * @param args
     */
    public static void main(String[] args) {
        Server server = new Server();
        //初始化
        server.init();



        int i = 0;
        while (true) {
            i++;
            String name = "name" + i;
            String result = server.doWork(name);
            System.out.println(result);
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //only prevent idea from reporting error.
            if (1 == 2) {
                break;
            }

        }
    }

}