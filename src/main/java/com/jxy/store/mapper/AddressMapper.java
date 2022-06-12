package com.jxy.store.mapper;

import com.jxy.store.entity.Address;

import java.util.Date;
import java.util.List;

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

    /**
     * 用过uid来查询用户的收货地址
     * @param uid
     * @return
     */
    List<Address> findByUid(Integer uid);

    /**
     * 通过aid来查询数据
     * @param aid
     * @return
     */
    Address findByAid(Integer aid);

    /**
     * 根据uid来查询地址，收货地址全部修改为非默认
     * @param uid
     * @return
     */
    Integer updateNoDefault(Integer uid);

    /**
     * 根据aid来修改收货地址为默认
     * @param aid 用户aid
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return
     */
    Integer updateDefault(Integer aid, String modifiedUser, Date modifiedTime);

    /**
     * 根据aid，删除收货地址
     * @param aid 收货地址的id
     * @return 返回受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 查询出该用户最后一条修改的数据
     * @param uid 用户id
     * @return 最后一条修改的数据
     */
    Address findByModifiedTime(Integer uid);
}
