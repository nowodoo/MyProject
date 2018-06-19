package com.zach.dubbo.controller;

        import com.dianwoba.optimus.coupon.domain.result.RiderCouponResultDTO;
        import com.dianwoba.optimus.coupon.param.RiderCouponQueryParam;
        import com.dianwoba.optimus.coupon.provider.rider.RiderCouponQueryProvider;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;
        import java.util.List;

@RestController
@RequestMapping("/TestController")
public class TestController {

    @Resource
    RiderCouponQueryProvider riderCouponQueryProvider;

    /**
     * curl http://127.0.0.1:8088/TestController/test
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        RiderCouponQueryParam riderCouponQueryParam = new RiderCouponQueryParam();
        riderCouponQueryParam.setUserId(2);

        List<RiderCouponResultDTO> riderCouponResultDTOS = riderCouponQueryProvider.queryCoupon(riderCouponQueryParam);
        return "Hello Zach!";
    }
}
