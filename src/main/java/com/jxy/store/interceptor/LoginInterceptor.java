package com.jxy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 检测全局session对象中是否有uid数据，如果有则放行，没有则重定向到登录页面
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  处理器(url+Controller)
     * @return 返回值为true，放行当前的请求，如果为false则拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object obj = request.getSession().getAttribute("uid");
        //如果为空，则说明当前用户没有登陆过系统，需要重定向到登录页面
        if (obj == null) {
            response.sendRedirect("/web/login.html");
            //结束后续的调用
            return false;
        }
        //请求放行
        return true;
    }
}
