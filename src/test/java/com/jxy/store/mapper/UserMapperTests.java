package com.jxy.store.mapper;

import com.jxy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("张三4");
        user.setPassword("123");
        Integer insert = userMapper.insert(user);
        if(insert>=1){
            System.out.println("添加成功!");
        }else {
            System.out.println("添加失败!");
        }
    }

}
