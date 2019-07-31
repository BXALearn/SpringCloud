package com.bxa.product.VO;

import lombok.Data;

/**
 * Create by 摆欣安
 * 2019/7/17 17:00
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
