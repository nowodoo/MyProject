package com.zach.dubboprovider.api.impl;

import com.alibaba.fastjson.JSON;
import com.zach.dubboprovider.api.ValidateProvider;
import com.zach.dubboprovider.dto.ValidateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidateProviderImpl implements ValidateProvider {
    private static Logger logger = LoggerFactory.getLogger(ValidateProviderImpl.class);

    @Override
    public boolean paramValidate(ValidateParam validateParam) {
        logger.info("enter paramValidate method:{}", JSON.toJSONString(validateParam));
        return false;
    }

    @Override
    public boolean save(ValidateParam validateParam) {
        logger.info("enter save method:{}", JSON.toJSONString(validateParam));
        return false;
    }
}
