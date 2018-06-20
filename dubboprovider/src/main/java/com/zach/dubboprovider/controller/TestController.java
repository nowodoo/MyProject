package com.zach.dubboprovider.controller;

import com.dianwoba.optimus.coupon.param.ValidationParam;
import com.dianwoba.optimus.coupon.provider.user.CouponUseProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/TestController")
public class TestController {


    @Resource
    CouponUseProvider couponUseProvider;


    /**
     * curl http://127.0.0.1:8088/TestController/test
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "Hello Zach!";
    }


    /**
     * curl http://127.0.0.1:8088/TestController/test
     * @return
     */
    @RequestMapping("/validation")
    public String validation() {

        ValidationParam validationParam = new ValidationParam();
        validationParam.setUserId(0L);


        couponUseProvider.paramTest(validationParam);
        return "Hello Zach!";
    }
}
