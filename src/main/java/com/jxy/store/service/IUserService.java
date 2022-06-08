package com.jxy.store.service;

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

    /**
     * 根据用户的id查询出用户的信息
     * @uid 用户id
     * @return 用户信息
     */
    User getByUid(Integer uid);

    /**
     * 修改用户信息
     * @param uid 用户id
     * @param username 用户名称
     * @param user 用户数据
     */

    void changeInfo(Integer uid,String  username,User user);

    /**
     * 上传/修改头像
     * @param uid
     * @param avatar
     * @param username
     */
    void changeAvatar(Integer uid,String avatar, String username);
}
