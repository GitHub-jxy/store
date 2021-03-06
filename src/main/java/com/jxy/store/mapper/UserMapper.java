package com.jxy.store.mapper;

import com.jxy.store.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 用户模块持久层接口
 */
@Repository
public interface UserMapper {
    /**
     * 插入用户数据
     * 通过返回的值/受影响的行数，来判断是否成功
     * @param user
     * @return
     */
    Integer insert (User user);

    /**
     * 根据用户名来查询改用户是否存在
     * @param name
     * @return
     */
    User findByUserName(String name);

    /**
     *  修改密码
     * @param uid 用户ID，根据用户ID修改面
     * @param password 原密码，作比较
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 查询该用户是否存在
     * @param uid
     * @return 找到的话返回对象，反之返回null
     */
    User findByUid(Integer uid);

    /**
     * 通过uid修改用户信息
     * @param user 用户对象
     * @return 返回影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * 通过uid来修改/上传用户头像
     * @param uid 用户id
     * @param avatar 头像
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 返回受影响的行数
     */
    Integer updateAvatarByUid(Integer uid, String avatar, String modifiedUser, Date modifiedTime);
}
