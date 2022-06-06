package com.jxy.store.service;

import com.jxy.store.entity.User;
import com.jxy.store.service.impl.ex.IUserService;
import com.jxy.store.service.impl.ex.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private IUserService iUserService;

    @Test
    public void insert(){
        try {
            User user = new User();
            user.setUsername("bbb");
            user.setPassword("123");
            iUserService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login(){
        User aaa = iUserService.login("aaaa", "123");
        if(aaa!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("登陆失败！");
        }
    }

    @Test
    public void changePassword(){
        iUserService.changePassword(2,"bbb","123","123456");
    }

    @Test
    public void getByUid(){
        System.err.println(iUserService.getByUid(1));
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setGender(1);
        user.setEmail("abcd@qq.com");
        iUserService.changeInfo(1,"aaa",user);
    }
}
