package com.zach.multithread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureContext {

    private ExecutorService threadPool = Executors.newFixedThreadPool(30);


    public void doExecute() {
        //数据
        List<DataBean> datas = DataUtil.createData();
        //存放多线程结果的集合
        List<Future<Map<String, Object>>> resultList = new ArrayList<Future<Map<String, Object>>>();




    }

}
