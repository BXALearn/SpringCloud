package com.bxa.product.utils;

import com.bxa.product.VO.ResultVO;

/**
 * Create by 摆欣安
 * 2019/7/17 17:21
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
