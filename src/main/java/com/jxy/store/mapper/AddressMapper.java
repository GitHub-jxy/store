package com.jxy.store.mapper;

import com.jxy.store.entity.Address;

/**
 * 收货地址 mapper
 */
public interface AddressMapper {

    /**
     * 插入用户的收货地址
     * @param address 收货地址的数据
     * @return 受影响的行数
     */
    Integer insertAddress(Address address);

    /**
     * 根据用户的uid来查询收货地址的总数
     * @param uid 用户uid
     * @return 返回总行数
     */
    Integer countByUid(Integer uid);

    Integer updateByIsDefault(Integer aid);

    Address selectAddressByUid(Integer uid);
}
