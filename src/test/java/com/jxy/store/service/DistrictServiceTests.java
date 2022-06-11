package com.jxy.store.service;

import com.jxy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTests {

    @Autowired
    DistrictService districtService;

    @Test
    public void getByParent(){
        List<District> byParent = districtService.getByParent("86");
        for (District district : byParent) {
            System.out.println(district);
        }
    }

    @Test
    public void district(){
        List<District> byParent = districtService.getByParent("120000");
        for (District district : byParent) {
            System.out.println(district);
        }
    }

}
