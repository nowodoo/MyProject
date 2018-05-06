package com.zach.multithread.future;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<DataBean> createData() {
        List<DataBean> datas = new ArrayList<DataBean>();

        for (int i = 0; i < 100; i++) {
            DataBean dataBean = new DataBean();
            dataBean.setId(i);
            dataBean.setName("姓名" + i);
            datas.add(dataBean);
        }

        return datas;
    }
}
