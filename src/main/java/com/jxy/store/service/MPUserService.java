package com.jxy.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxy.store.entity.TUser;
import com.jxy.store.mapper.MPUserMapper;

import java.util.List;

public interface MPUserService extends IService<TUser> {

    /**
     * 通过MP修改email
     * @return
     */
    void updateEmail(Integer uid,String userName,TUser tUser);

    /**
     * 添加
     * @param tUser
     */
    void insert(TUser tUser);

    /**
     * 查询全部
     * @return
     */
    List<TUser> selectAll();

    /**
     * 查询总条数
     * @return
     */
    Integer selectCount();

}
