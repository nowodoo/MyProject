package com.zach.common.list;

import java.util.ArrayList;
import java.util.HashSet;

public class ListDemo {

    public static void main(String[] args) {
        ArrayList<String> dbList = new ArrayList<String>();
        ArrayList<String> logList = new ArrayList<String>();


        ArrayList<Object> all = new ArrayList<>();
        all.addAll(dbList);
        all.addAll(logList);


        System.out.println("all the data: " + all.size());


        //deduplicate
        HashSet<String> dbSet = new HashSet<>(dbList);
        HashSet<String> logSet = new HashSet<>(logList);


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
