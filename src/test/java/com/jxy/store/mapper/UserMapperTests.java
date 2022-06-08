package com.jxy.store.mapper;

import com.jxy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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

    @Test
    public void update(){
        Date date = new Date();
        Integer result = userMapper.updatePasswordByUid(1, "123123", "张三aaa", date);
        if(result>=1){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }

    @Test
    public void select(){
        User result = userMapper.findByUid(1);
        if(result!=null){
            System.out.println("查询成功！");
            System.out.println(result);
        }else{
            System.out.println("查询失败！");
        }
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(1);
        user.setGender(0);
        user.setPhone("17630888888");
        user.setEmail("2581039666@qq.com");
        Integer integer = userMapper.updateInfoByUid(user);
        if(integer>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Test
    public void updateAvtar(){
        //Integer uid, String avatar, String modifiedUser, Date modifiedTime
        Integer integer = userMapper.updateAvatarByUid(1,"D:abc.jpg","张三",new Date());
        if(integer!=1){
            System.out.println("修改失败/修改时产生异常！");
        }
    }

}
