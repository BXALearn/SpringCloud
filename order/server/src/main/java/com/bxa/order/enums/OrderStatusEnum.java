package com.bxa.order.enums;

import lombok.Getter;

/**
 * Create by 摆欣安
 * 2019/7/18 10:19
 */
@Getter
public enum  OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

}
