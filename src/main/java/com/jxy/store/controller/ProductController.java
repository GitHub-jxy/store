package com.jxy.store.controller;

import com.jxy.store.entity.Product;
import com.jxy.store.service.ProductService;
import com.jxy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController extends BaseController{

    @Autowired
    ProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> hotList(){
        List<Product> hotList = productService.findHotList();
        return new JsonResult<List<Product>>(OK,hotList);
    }

}
