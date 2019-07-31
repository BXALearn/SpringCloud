package com.bxa.user.repository;

import com.bxa.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by 摆欣安
 * 2019/7/28 17:51
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);

}
