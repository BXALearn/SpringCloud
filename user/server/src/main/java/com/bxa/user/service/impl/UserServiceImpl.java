package com.bxa.user.service.impl;

import com.bxa.user.dataobject.UserInfo;
import com.bxa.user.repository.UserInfoRepository;
import com.bxa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by 摆欣安
 * 2019/7/28 17:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository repository;

    /**
     * 通过openid来查询用户信息
     *
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
