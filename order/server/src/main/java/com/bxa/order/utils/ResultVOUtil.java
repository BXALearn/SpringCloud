package com.bxa.order.utils;

import com.bxa.order.VO.ResultVO;

/**
 * Create by 摆欣安
 * 2019/7/18 20:53
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
