package com.jxy.store.service.impl;

import com.jxy.store.entity.Product;
import com.jxy.store.mapper.ProductMapper;
import com.jxy.store.service.ProductService;
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
}
