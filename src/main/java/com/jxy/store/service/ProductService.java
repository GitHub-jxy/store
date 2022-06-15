package com.jxy.store.service;

import com.jxy.store.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询热销商品的前四名
     * @return
     */
    List<Product> findHotList();

}
