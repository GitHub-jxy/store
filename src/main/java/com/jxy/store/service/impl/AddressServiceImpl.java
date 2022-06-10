package com.jxy.store.service.impl;

import com.jxy.store.entity.Address;
import com.jxy.store.mapper.AddressMapper;
import com.jxy.store.service.AddressService;
import com.jxy.store.service.ex.AddressCountLimitException;
import com.jxy.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Value("${user.address.max-count}")
    private int maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if (count > maxCount) {
            throw new AddressCountLimitException("收货地址超出限制异常");
        }
        //1--默认  0--不默认
        Integer isDefault = count == 0 ? 1 : 0;
        //设置收货地址的uid
        address.setUid(uid);
        //设置是否为默认，如果count==1的时候，为默认，否则不默认
        address.setIsDefault(isDefault);
        //设置四大日志信息
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        Integer result = addressMapper.insertAddress(address);
        if (result != 1) {
            throw new InsertException("添加收货地址信息时异常");
        }
    }

    @Override
    public Integer updateByIsDefault(Integer uid) {
        Integer integer = addressMapper.countByUid(uid);
        Address address = addressMapper.selectAddressByUid(uid);
        Integer aid = address.getAid();
        if (integer == 1) {
            Integer result = addressMapper.updateByIsDefault(aid);
            if (result == 1) {
                System.out.println("查询出来的收货地址只有一条，则直接设置当前收货地址为默认地址");
            }
        }
        return null;
    }
}
