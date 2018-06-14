package com.zach.dubbo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestController")
public class TestController {

    /**
     * curl http://127.0.0.1:8088/TestController/test
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "123";
    }
}
