package com.bxa.order.exception;

import com.bxa.order.enums.ResultEnum;

/**
 * Create by 摆欣安
 * 2019/7/18 20:33
 */
public class OrderException extends RuntimeException{
    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
