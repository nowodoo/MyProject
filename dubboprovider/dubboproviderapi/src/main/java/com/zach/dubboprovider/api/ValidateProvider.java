package com.zach.dubboprovider.api;

import com.zach.dubboprovider.dto.ValidateParam;

public interface ValidateProvider {
    boolean paramValidate(ValidateParam validateParam);
}
