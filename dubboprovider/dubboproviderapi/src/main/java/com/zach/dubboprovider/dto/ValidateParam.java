package com.zach.dubboprovider.dto;


import com.zach.dubboprovider.api.ValidateProvider;
import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class ValidateParam implements Serializable {
    private static final long serialVersionUID = 4148310595461808120L;

    @Min.List({
            @Min(value = 10, message = "数值过小!", groups = {ValidateProvider.ParamValidate.class}),
            @Min(value = 5, message = "数值过小!", groups = {ValidateProvider.Save.class})
    })
    private Long userId;

}
