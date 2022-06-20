package com.jxy.store.service;

import com.jxy.store.entity.CartVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void getVOByCids(){
        Integer[] cids = {1,2,3,4,5,6,7,8,9};
        List<CartVo> voByCids = cartService.getVOByCids(1, cids);
        for (CartVo voByCid : voByCids) {
            System.out.println(voByCid);
        }
    }

}
