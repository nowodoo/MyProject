package com.zach.dubbo.controller;

import com.zach.dubboprovider.api.ValidateProvider;
import com.zach.dubboprovider.dto.ValidateParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/TestController")
public class TestController {


    @Resource
    ValidateProvider validateProvider;

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
}
