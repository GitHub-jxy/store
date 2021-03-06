package com.jxy.store.mapper;

import com.jxy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTests {

    @Autowired
    DistrictMapper districtMapper;

    @Test
    public void findByParent(){
        List<District> byParent = districtMapper.findByParent("86");
        for (District district : byParent) {
            System.out.println(district);
        }
    }

    @Test
    public void findByCode(){
        String name = districtMapper.findByCode("410000");
        System.out.println(name);
    }

}
