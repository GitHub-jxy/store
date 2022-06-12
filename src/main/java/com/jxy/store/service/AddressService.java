package com.jxy.store.service;

import com.jxy.store.entity.Address;

import java.util.List;

public interface AddressService {

    /**
     * 新增 收货地址
     * @param uid
     * @param username
     * @param address
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * 用过uid来查询用户的收货地址
     * @param uid 用户id
     * @return 所有的收货地址
     */
    List<Address> selectAddressByUid(Integer uid);

    /**
     * 修改收货地址为默认的收货地址
     * @param aid 收货地址id
     * @param uid 用户id
     * @param username 修改者
     */
    void setDefault(Integer aid,Integer uid,String username);
}
