package com.jxy.store.service;

import com.jxy.store.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询热销商品的前四名
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
