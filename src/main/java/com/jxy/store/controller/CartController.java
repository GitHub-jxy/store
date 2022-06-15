package com.jxy.store.controller;

import com.jxy.store.entity.Cart;
import com.jxy.store.entity.CartVo;
import com.jxy.store.service.CartService;
import com.jxy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping({"","/"})
    public JsonResult<List<CartVo>> list(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<CartVo> data = cartService.getVOByUid(uid);
//        for (CartVo cartVo : data) {
//            System.out.println(data);
//        }
        return new JsonResult<List<CartVo>>(OK,data);
    }

}
