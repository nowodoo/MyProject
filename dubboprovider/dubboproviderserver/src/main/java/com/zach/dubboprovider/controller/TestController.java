package com.zach.dubboprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestController")
public class TestController {

    /**
     * curl http://localhost:8090/TestController/test
     * curl -k  https://localhost:8093/TestController/test
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "Hello Zach!";
    }
}
