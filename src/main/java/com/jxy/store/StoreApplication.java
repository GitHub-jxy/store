package com.jxy.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

//表示配置/修改类
@Configuration

@MapperScan("com.jxy.store.mapper")
@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    //方式一，properties文件里直接设置文件/请求的大小
    //方式二，上面的 @Configuration 注解是必须的

    /**
     * 通过工厂模式来，控制文件上传的大小
     * @return
     */
    @Bean
    public MultipartConfigElement getMultipartConfigElement(){
        //创建工厂
        MultipartConfigFactory factory = new MultipartConfigFactory();

        //配置出厂要求
        //设置文件的大小，最大为10,单位为M
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        //设置请求的大小，最大为10，单位为M
        factory.setMaxRequestSize(DataSize.of(15, DataUnit.MEGABYTES));

        //配置完成之后，开始创建
        MultipartConfigElement multipartConfig = factory.createMultipartConfig();

        //返回
        return multipartConfig;
    }

}
