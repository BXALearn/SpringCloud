package com.bxa.user.enums;

import lombok.Getter;

/**
 * Create by 摆欣安
 * 2019/7/18 10:25
 */
@Getter
public enum RoleEnum {
    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
