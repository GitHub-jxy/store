package com.jxy.store.mapper;

import com.jxy.store.entity.Cart;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTests {

    @Autowired
    CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setPid(1);
        cart.setPrice(1000L);
        cart.setNum(1);
        cart.setCreatedUser("张三");
        cart.setCreatedTime(new Date());
        cart.setModifiedUser("张三");
        cart.setModifiedTime(new Date());

        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid(){

        Integer cid = 1;
        Integer num = 5;
        String modifiedUser = "李四";
        Date modifiedTime = new Date();

        cartMapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);

    }

    @Test
    public void findByUidAndPid(){

        Cart byUidAndPid = cartMapper.findByUidAndPid(1, 15);
        if(byUidAndPid != null){
            System.out.println(byUidAndPid);
        }else{
            System.out.println("空");
        }

    }

}
