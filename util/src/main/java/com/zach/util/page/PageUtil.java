package com.zach.util.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * @author maluyong
 *
 */
public final class PageUtil {

    public static List<PageBean> getPageList(int count, int step) {

        if (count < 0 || step < 0) {
            throw new RuntimeException("数值不允许为0!");
        }

        List<PageBean> list = new ArrayList<>();
        int pageNum = (count / step) + ((count > 0 && (0 != count % step)) ? 1 : 0);

        for (int i = 0; i < pageNum; i++) {
            int limitStart = i * step;
            int limitNum = step;


            //添加bean
            PageBean pageBean = new PageBean();
            pageBean.setStart(limitStart);
            pageBean.setLimit(limitNum);
            pageBean.setPageNum(pageNum);
            list.add(pageBean);
        }
        return list;
    }
}
