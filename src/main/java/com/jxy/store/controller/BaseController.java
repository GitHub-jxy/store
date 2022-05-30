package com.jxy.store.controller;

import com.jxy.store.service.impl.ex.ex.PasswordNotMatchException;
import com.jxy.store.service.impl.ex.ex.ServiceException;
import com.jxy.store.service.impl.ex.ex.UserNameDuplicatedException;
import com.jxy.store.service.impl.ex.ex.UserNotFoundException;
import com.jxy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    public static final int OK = 200;

    //当项目中产生了异常，被统一拦截到此方法中，这个方法此时充当的是请求处理的方法，返回值会直接返回到前端；
    //只要是属于这个类里面的异常，都进入到改方法
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handler(Throwable e){

        JsonResult<Void> result = new JsonResult<>(e);
        //判断数据类型是否属于UserNameDuplicatedException类型的
        if(e instanceof UserNameDuplicatedException){
            //如果是/属于
            result.setState(4000);
            result.setMessage("用户名重复");
        }else if(e instanceof InstantiationError ){
            result.setState(5000);
            result.setMessage("插入时异常");
        }else if(e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户名不存在");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("用户名密码不正确");
        }
        return result;
    }


}
