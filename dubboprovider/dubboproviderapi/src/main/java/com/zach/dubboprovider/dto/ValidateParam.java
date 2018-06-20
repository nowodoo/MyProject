package com.zach.dubboprovider.dto;


import javax.validation.constraints.Min;
import java.io.Serializable;

public class ValidateParam implements Serializable {
    private static final long serialVersionUID = 4148310595461808120L;

    @Min(value = 10, message = "数值过小!")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
