package com.bxa.user.service;

import com.bxa.user.dataobject.UserInfo;

/**
 * Create by 摆欣安
 * 2019/7/28 17:56
 */
public interface UserService {

    /**
     * 通过openid来查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);

}
