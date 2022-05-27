package com.jxy.store.service.impl.ex.impl;

import com.jxy.store.entity.User;
import com.jxy.store.mapper.UserMapper;
import com.jxy.store.service.impl.ex.IUserService;
import com.jxy.store.service.impl.ex.ex.InsertException;
import com.jxy.store.service.impl.ex.ex.UserNameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

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

    private String getMD5Password(String password,String salt){
        for (int i = 0; i < 3 ; i++) {
            //三次加密
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
