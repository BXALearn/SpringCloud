package com.bxa.user.VO;

import lombok.Data;

/**
 * Create by 摆欣安
 * 2019/7/18 20:52
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
