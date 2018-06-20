package com.zach.dubboprovider.api.impl;

import com.zach.dubboprovider.api.ValidateProvider;
import com.zach.dubboprovider.dto.ValidateParam;
import org.springframework.stereotype.Service;

@Service
public class ValidateProviderImpl implements ValidateProvider {

    @Override
    public boolean paramValidate(ValidateParam validateParam) {

        return false;
    }
}
