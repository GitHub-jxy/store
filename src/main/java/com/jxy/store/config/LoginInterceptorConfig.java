package com.jxy.store.config;

import com.jxy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

// @Configuration 加载当前的拦截器
@Configuration
// 处理器拦截器的注册
public class LoginInterceptorConfig implements WebMvcConfigurer {

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //创建自定义的拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        //白名单
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/district/**");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")//全部拦截
                .excludePathPatterns(patterns);//除了谁以为(list)
      //WebMvcConfigurer.super.addInterceptors(registry);
    }
}
