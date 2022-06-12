package com.jxy.store.mapper;

import com.jxy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {

    @Autowired
    AddressMapper addressMapper;

    @Test
    public void insertAddress(){
        Address address = new Address();
        address.setUid(1);
        address.setName("张三");
        address.setProvinceName("浙江");
        address.setProvinceCode("100");
        address.setCityName("杭州");
        address.setCityCode("101");
        address.setAreaName("钱塘区");
        address.setAreaCode("钱塘区");
        address.setZip("461670");
        address.setAddress("5G产业园，联核科技有限公司");
        address.setPhone("17630888888");
        address.setTel("12345678");
        address.setTag("公司");
        address.setIsDefault(0);
        address.setCreatedUser("张三");
        address.setCreatedTime(new Date());
        address.setModifiedUser("张三");
        address.setModifiedTime(new Date());
        Integer integer = addressMapper.insertAddress(address);
        if(integer>=1){
            System.out.println("测试插入收货地址成功OK");
        }
    }

    @Test
    public void countByUid(){
        Integer integer = addressMapper.countByUid(1);
        System.out.println(integer);
    }

    @Test
    public void selectAddressByUid(){
        List<Address> addresses = addressMapper.findByUid(1);
        for (Address address : addresses) {
            System.out.println(address);
        }

    }

    @Test
    public void findByAid(){
        Address byAid = addressMapper.findByAid(1);
        System.out.println(byAid);
    }

    @Test
    public void updateNoDefault(){
        Integer integer = addressMapper.updateNoDefault(1);
        if (integer >= 1){
            System.out.println("修改成功");
        }
    }

    @Test
    public void updateDefault(){
        Integer integer = addressMapper.updateDefault(1, "张三", new Date());
        if (integer >= 1){
            System.out.println("修改成功");
        }
    }

    @Test
    public void deleteByAid(){
        Integer integer = addressMapper.deleteByAid(2);
        if (integer >= 1){
            System.out.println("删除成功");
        }
    }

    @Test
    public void findByModifiedTime(){
        Address byModifiedTime = addressMapper.findByModifiedTime(1);
        System.out.println(byModifiedTime);

    }

}
