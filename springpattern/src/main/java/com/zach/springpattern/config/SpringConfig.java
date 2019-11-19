package com.zach.springpattern.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanqin
 * 时间: 2019/11/17.
 * 相关业务:
 */
@Configuration
public class SpringConfig {

    @Bean(name="testBean")
    public String testBean() {
        return "test";
    }
}
