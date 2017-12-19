package com.zach.common.list;

import java.util.ArrayList;
import java.util.HashSet;

public class ListDemo {

    public static void main(String[] args) {
        ArrayList<String> dbList = new ArrayList<String>();
        dbList.add("1");
        dbList.add("2");
        dbList.add("3");
        ArrayList<String> logList = new ArrayList<String>();
        logList.add("3");
        logList.add("4");


        ArrayList<String> all = new ArrayList<String>();
        all.addAll(dbList);
        all.addAll(logList);


        System.out.println("all the data: " + all.size());


        //deduplicate
        HashSet<String> dbSet = new HashSet<String>(dbList);
        HashSet<String> logSet = new HashSet<String>(logList);


        //intersection
        ArrayList<String> similar = new ArrayList<String>(dbList);
        similar.retainAll(logList);


        //get a & b remove intersection
        dbList.removeAll(similar);
        logList.removeAll(similar);
        System.out.println(dbList);
        System.out.println(logList);


    }
    
}
