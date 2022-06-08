package com.jxy.store.service.impl;

import com.jxy.store.entity.User;
import com.jxy.store.mapper.UserMapper;
import com.jxy.store.service.ex.*;
import com.jxy.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        /**
         * 先判断该用户名是否被占用/存在
         */
        String username = user.getUsername();
        User result = userMapper.findByUserName(username);
        if (result != null) {
            throw new UserNameDuplicatedException("用户名被占用");
        }

        String oldPassword = user.getPassword();
        //密码操作
        String salt = UUID.randomUUID().toString().toUpperCase();
        //随机生成的盐值进行保存，后续验证密码的时候方便验证
        user.setSalt(salt);
        //String newPassword = salt+oldPassword+salt;
        String md5Password = getMD5Password(oldPassword, salt);
        user.setPassword(md5Password);

        //补全信息 is_deleted、四个日志信息
        user.setIsDelete(0);
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());

        Integer insert = userMapper.insert(user);
        if (insert >= 1) {
            System.out.println("插入成功！");
        } else {
            throw new InsertException("插入时异常！");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUserName(username);
        if (username != null) {
            if (result == null) {
                throw new UserNotFoundException("用户不能为空！");
            }
            //不等于空说明有用户
            //获取到盐值
            String salt = result.getSalt();
            //获取到密码
            String resultPassword = result.getPassword();
            String md5Password = getMD5Password(password, salt);
            //拿到时候被删除的信息
            Integer isDelete = result.getIsDelete();
            if (!md5Password.equals(resultPassword)) {
                //两者密码进行比对
                throw new PasswordNotMatchException("密码不正确！");
            }
            if (isDelete == 1) {
                throw new UserNotFoundException("该用户已被删除！");
            }
        }
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User resultID = userMapper.findByUid(uid);
        User resultName = userMapper.findByUserName(username);
        if (resultID == null || resultName == null) {
            throw new UpdateException("修改密码时，无法查找到对应的账户！");
        }

        //拿到用户的盐值
        String salt = resultName.getSalt();
        //拿到用户的密码
        String password = resultName.getPassword();
        //进行MD5加密
        String md5Password = getMD5Password(oldPassword, salt);
        //密码进行比较
        if (!password.equals(md5Password)) {
            throw new UpdateException("当前密码与原密码不一致，请重新输入！");
        }
        String newMD5Password = getMD5Password(newPassword, salt);
//        //修改密码
//        resultName.setPassword(newMD5Password);
        Integer integer = userMapper.updatePasswordByUid(uid, newMD5Password, username, new Date());
        if (integer != null) {
            System.out.println("修改成功！");
        } else {
            throw new InsertException("更新时产生未知的异常！");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据未找到或已删除！");
        }
        //判断完是否为空后，把前端需要的对象封装起来，返回给前端；
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据未找到或已删除！");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer integer = userMapper.updateInfoByUid(user);
        if (integer != 1) {
            throw new UpdateException("修改信息时，出现未知的异常！");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据未找到或已删除！");
        }
        Integer integer = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (integer != 1) {
            throw new UpdateException("修改信息时，出现未知的异常！");
        }
    }

    private String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            //三次加密
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
