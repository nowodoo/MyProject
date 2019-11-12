package com.zach.common.util.page;

/**
 * @author wanqin
 * 时间: 2019-07-03.
 * 相关业务:
 */
public class PageUtil {
    public static Integer getPageCnt(Integer totalNum, Integer pageSize) {
        if (totalNum == null || pageSize == null || totalNum == 0 || pageSize == 0) {
            return 0;
        }

        Integer pageNum = totalNum / pageSize;
        if (totalNum % pageSize > 0) {
            pageNum += 1;
        }

        return pageNum;
    }
}
