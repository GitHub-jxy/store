package com.jxy.store.service.impl;

import com.jxy.store.entity.Product;
import com.jxy.store.mapper.ProductMapper;
import com.jxy.store.service.ProductService;
import com.jxy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        List<Product> hotList = productMapper.findHotList();

        return hotList;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        if(product==null){
            throw new ProductNotFoundException("找不到改商品");
        }
        Integer status = product.getStatus();
        if(status == 3){
            throw new ProductNotFoundException("该商品已被删除");
        }
        if(status == 2){
            throw new ProductNotFoundException("该商品已被下架");
        }
        return product;
    }
}
