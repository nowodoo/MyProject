package com.zach.dubboprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

@Configuration
@ImportResource(locations = { "classpath*:dubbo/app-context-*" })
public class AppContext implements EnvironmentAware {
    private static Logger logger = LoggerFactory.getLogger(AppContext.class);


    @Override
    public void setEnvironment(Environment environment) {
        logger.info("get environment:{}", environment.getActiveProfiles());
    }
}