package com.jxy.store.service.impl.ex;

import com.jxy.store.entity.User;

public interface IUserService {

    /**
     * 用户注册接口
     * @param user
     */
    void reg(User user);

    /**
     * 用户登录接口
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
}
