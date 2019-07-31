package com.bxa.order.enums;

import lombok.Getter;

/**
 * Create by 摆欣安
 * 2019/7/18 10:24
 */

@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
