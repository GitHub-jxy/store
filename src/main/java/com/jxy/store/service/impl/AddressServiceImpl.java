package com.jxy.store.service.impl;

import com.jxy.store.entity.Address;
import com.jxy.store.mapper.AddressMapper;
import com.jxy.store.service.AddressService;
import com.jxy.store.service.ex.AddressCountLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer integer = addressMapper.countByUid(uid);
        if(integer>20){
            throw new AddressCountLimitException("收货地址超出限制异常");
        }

//        addressMapper.insertAddress()
    }

    @Override
    public Integer updateByIsDefault(Integer uid) {
        Integer integer = addressMapper.countByUid(uid);
        Address address = addressMapper.selectAddressByUid(uid);
        Integer aid = address.getAid();
        if (integer == 1) {
            Integer result = addressMapper.updateByIsDefault(aid);
            if(result == 1){
                System.out.println("查询出来的收货地址只有一条，则直接设置当前收货地址为默认地址");
            }
        }
        return null;
    }
}
