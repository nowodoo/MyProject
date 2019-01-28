package com.zach.dubbo.controller;

import com.dianwoba.optimus.coupon.domain.result.RiderCouponResultDTO;
import com.dianwoba.optimus.coupon.param.RiderCouponKeyParam;
import com.dianwoba.optimus.coupon.provider.rider.RiderCouponQueryProvider;
import com.zach.dubboprovider.api.ValidateProvider;
import com.zach.dubboprovider.dto.ValidateParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TestController")
public class TestController {


    @Resource
    ValidateProvider validateProvider;

//    @Resource
//    RiderCouponQueryProvider riderCouponQueryProvider;

    /**
     * curl http://127.0.0.1:8088/TestController/test
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        ValidateParam validateParam = new ValidateParam();
        validateParam.setUserId(0L);


        boolean b = validateProvider.paramValidate(validateParam);
        return "Hello Zach!" + b;
    }

    /**
     * curl http://127.0.0.1:8088/TestController/testSave
     * @return
     */
    @RequestMapping("/testSave")
    public String testSave() {
        ValidateParam validateParam = new ValidateParam();
        validateParam.setUserId(4L);

        boolean b = validateProvider.save(validateParam);
        return "Hello Zach!" + b;
    }

    /**
     * curl http://127.0.0.1:8088/TestController/test12
     * @return
     */
    @RequestMapping("/test12")
    public String test12() {
//        ArrayList<RiderCouponKeyParam> objects = new ArrayList<>();
//        List<RiderCouponResultDTO> riderCouponResultDTOS = riderCouponQueryProvider.listRiderCoupon(objects);
        return "ok";
    }
}
