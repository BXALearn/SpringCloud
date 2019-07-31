package com.bxa.product.exception;

import com.bxa.product.enums.ResultEnum;

/**
 * Create by 摆欣安
 * 2019/7/26 11:31
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}