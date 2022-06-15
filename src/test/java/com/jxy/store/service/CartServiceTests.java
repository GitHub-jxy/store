package com.jxy.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CartServiceTests {

    @Autowired
    CartService cartService;

    @Test
    public void addToCart(){
        /**
         * Integer uid,Integer pid,Integer num,String username
         */
        Integer uid = 1;
        Integer pid = 2;
        Integer num = 50;
        String username = "李四";

        try {
            cartService.addToCart(uid,pid,num,username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
