package com.jxy.store.service;


import com.jxy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    AddressService addressService;

    @Test
    public void insertAddress(){
        Address address = new Address();
        address.setCityName("北上广");
        address.setAddress("不相信眼泪");
        addressService.addNewAddress(1,"张三",address);
    }

    @Test
    public void setDefault(){
        //0-不默认，1-默认
       addressService.setDefault(2,1,"张三");
    }

    @Test
    public void deleteByAid(){
        //0-不默认，1-默认
        addressService.deleteAddressByAid(4,2,"张三");
    }

}
