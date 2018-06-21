package com.zach.dubboprovider.api;

import com.zach.dubboprovider.dto.ValidateParam;

public interface ValidateProvider {

    @interface ParamValidate{}
    public boolean paramValidate(ValidateParam validateParam);

    @interface Save{}
    public boolean save(ValidateParam validateParam);
}
