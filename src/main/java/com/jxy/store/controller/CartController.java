package com.jxy.store.controller;

import com.jxy.store.entity.Cart;
import com.jxy.store.service.CartService;
import com.jxy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController{

    @Autowired
    CartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Cart> addToCart(HttpSession session,Integer pid,Integer num){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        cartService.addToCart(uid,pid,num,username);
        return new JsonResult<Cart>(OK);
    }

}
