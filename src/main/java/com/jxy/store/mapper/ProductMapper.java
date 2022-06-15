package com.jxy.store.mapper;

import com.jxy.store.entity.Product;

import java.util.List;

public interface ProductMapper {

    /**
     * 根据num进行排序
     * @return 排序列表
     */
    List<Product> selectByNum();

    /**
     * 根据ModifiedTime进行排序
     * @return 排序列表
     */
    List<Product> selectByModifiedTime();

    /**
     * 查询热销商品的前四名，根据priority进行排序
     * @return
     */
    List<Product> findHotList();

    /**
     * 通过商品id，查询商品
     * @param id 商品id
     * @return 商品
     */
    Product findById(Integer id);

}
