package com.jxy.store.mapper;

import com.jxy.store.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    public void selectByNum(){
        List<Product> products = productMapper.selectByNum();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void selectByModifiedTime(){
        List<Product> products = productMapper.selectByModifiedTime();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void findHotList(){
        List<Product> products = productMapper.findHotList();
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
