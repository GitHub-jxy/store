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

    /**
     * 修改密码
     * @param uid 用户id
     * @param username 用户名称
     * @param oldPassword 用户修改的原密码
     * @param newPassword 用户修改的新密码
     */
    void changePassword(Integer uid,String  username, String oldPassword,String newPassword);
}
