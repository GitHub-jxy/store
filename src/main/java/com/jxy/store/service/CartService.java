package com.jxy.store.service;

import com.jxy.store.entity.CartVo;

import java.util.List;

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

    List<CartVo> getVOByUid(Integer uid);

    /**
     * 通过uid来控制物品进行+1
     * @param uid 用户id
     * @param cid 购物车id
     * @param username 修改人
     * @return num+1
     */
    Integer addNum(Integer uid,Integer cid,String username);

    /**
     * 通过uid来控制物品进行-1
     * @param uid 用户id
     * @param cid 购物车id
     * @param username 修改人
     * @return num-1
     */
    Integer reduceNum(Integer uid,Integer cid,String username);

}
