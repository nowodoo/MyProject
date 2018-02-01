package com.zach.util.range;

import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FileUtilTest {
    @Test
    public void test() {
        String[] headers = new String[]{"支付宝交易号","商户订单号","业务类型","商品名称","创建时间","完成时间","门店编号","门店名称","操作员","终端号","对方账户","订单金额（元）","商家实收（元）","支付宝红包（元）","集分宝（元）","支付宝优惠（元）","商家优惠（元）","券核销金额（元）","券名称","商家红包消费金额（元）","卡消费金额（元）","退款批次号/请求号","服务费（元）","分润（元）","备注"};
        try {
            String path = this.getClass().getResource("/files").getPath();

            String fileEncoding = FileUtil.getFileEncoding(path+"/test.csv");
            System.out.println(fileEncoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
