package com.jxy.store.mapper;

import com.jxy.store.entity.Cart;

import java.util.Date;

// 购物车
public interface CartMapper {

    /**
     * 添加商品
     * @param cart
     * @return
     */
    Integer insert(Cart cart);

    /**
     * 通过购物车cid，修改数量
     * @param cid 购物车的id
     * @param num 修改的数量
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return
     */
    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    /**
     * 通过用户uid，查询选中的商品pid是否在购物车里面
     * @param pid 用户ID
     * @param pid 商品ID
     * @return 返回查询出来的行数
     */
    Cart findByUidAndPid(Integer uid,Integer pid);

}
