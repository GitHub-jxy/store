package com.jxy.store.service.impl;

import com.jxy.store.entity.Cart;
import com.jxy.store.entity.Product;
import com.jxy.store.mapper.CartMapper;
import com.jxy.store.service.CartService;
import com.jxy.store.service.ProductService;
import com.jxy.store.service.ex.InsertException;
import com.jxy.store.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

//购物车业务层
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    ProductService productService;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer num, String username) {
        Cart cart = cartMapper.findByUidAndPid(uid, pid);
        if (cart != null) {
            //不等于空，说明已经在购物车里了
            //拿到当前数据的cid
            Integer cid = cart.getCid();
            //进行修改
            Integer integer = cartMapper.updateNumByCid(cid, num, username, new Date());
            if(integer>=1){
                System.out.println("修改成功");
            }else{
                throw new UpdateException("修改商品数量时，异常！");
            }
        } else {
            //等于空，说明还未添加到购物车

            //通过productService调用findById方法，得到商品的价格
            Product product = productService.findById(pid);
            Long price = product.getPrice();

            Cart newCart = new Cart();
            newCart.setUid(uid);
            newCart.setPid(pid);
            newCart.setPrice(price);
            newCart.setNum(num);
            //四大日志
            newCart.setCreatedUser(username);
            newCart.setCreatedTime(new Date());
            newCart.setModifiedUser(username);
            newCart.setModifiedTime(new Date());
            Integer insert = cartMapper.insert(newCart);
            if(insert>=1){
                System.out.println("添加成功");
            }else{
                throw new InsertException("添加商品时，出现未知的异常");
            }
        }
    }

}
