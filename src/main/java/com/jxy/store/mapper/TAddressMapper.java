package com.jxy.store.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxy.store.entity.Address;
import com.jxy.store.entity.TAddress;
import org.apache.ibatis.annotations.Param;


public interface TAddressMapper extends BaseMapper<TAddress> {
    /**
     * 插入用户的收货地址
     * @param address 收货地址的数据
     * @return 受影响的行数
     */
//    Integer insertAddress(TAddress address);

    /**
     * 根据用户的uid来查询收货地址的总数
     *
     * @return 返回总行数
     */
    Long selectCount(@Param("ew")  Wrapper<TAddress> queryWrapper);

    @Override
    int update(TAddress entity, Wrapper<TAddress> updateWrapper);
}
