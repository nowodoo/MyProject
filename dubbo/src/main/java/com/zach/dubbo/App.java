package com.zach.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(App.class).profiles("dev").build(args).run(args);
        logger.info("dubbo-service started !!!!");
        System.out.println("dubbo-service started !!!!");
    }
}
