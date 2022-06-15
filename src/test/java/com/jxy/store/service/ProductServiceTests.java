package com.jxy.store.service;

import com.jxy.store.entity.Product;
import com.jxy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Test
    public void findHotList(){
        List<Product> hotList = productService.findHotList();
        for (Product product : hotList) {
            System.out.println(product);
        }
    }

    @Test
    public void findById(){
//        Product byId = null;
        try {
            Product byId = productService.findById(1);
            System.out.println(byId);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

}
