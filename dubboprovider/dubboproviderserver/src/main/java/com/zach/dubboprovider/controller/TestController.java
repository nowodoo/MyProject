package com.zach.dubboprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestController")
public class TestController {

    /**
     * curl http://localhost:8090/TestController/test
     * curl http://localhost:8443/TestController/test
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "Hello Zach!";
    }
}
