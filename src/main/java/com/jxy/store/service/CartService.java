package com.jxy.store.service;

//购物车业务层
public interface CartService {

    /**
     * 添加购物车
     * @param uid 用户ID
     * @param pid 商品ID
     * @param num 添加/修改的数量
     * @param username 谁修改的
     */
    void addToCart(Integer uid,Integer pid,Integer num,String username);

}
