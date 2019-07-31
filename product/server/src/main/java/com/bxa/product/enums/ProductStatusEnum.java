package com.bxa.product.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * Create by 摆欣安
 * 2019/7/17 16:23
 */
@Getter
public enum  ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
