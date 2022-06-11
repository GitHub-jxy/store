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
     * @param uid
     * @return
     */
    List<Address> selectAddressByUid(Integer uid);
}
