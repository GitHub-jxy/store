package com.jxy.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxy.store.entity.TUser;
import com.jxy.store.mapper.MPUserMapper;
import com.jxy.store.service.MPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MPUserServiceImpl extends ServiceImpl<MPUserMapper, TUser> implements MPUserService {

    @Autowired
    MPUserMapper mpUserMapper;


    @Override
    public void updateEmail(Integer uid,String userName,TUser tUser) {

    }

    @Override
    public void insert(TUser tUser) {

        mpUserMapper.insert(tUser);
    }

    @Override
    public List<TUser> selectAll() {

        List<TUser> tUsers = mpUserMapper.selectList(null);
        return tUsers;
    }

    @Override
    public Integer selectCount() {
        //通过list.size实现计数，但是数据量大的话，不建议这么做
//        List<TUser> tUsers = mpUserMapper.selectList(null);
//        int size = tUsers.size();
//        mpUserMapper.selectCount(tUsers);
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<TUser>();
        queryWrapper.eq("is_delete",0);
        Long aLong = mpUserMapper.selectCount(queryWrapper);
        System.out.println(aLong);
        return null;
    }
}
