package com.jxy.store.controller;

import com.jxy.store.controller.ex.*;
import com.jxy.store.service.ex.*;
import com.jxy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {

    public static final int OK = 200;

    //当项目中产生了异常，被统一拦截到此方法中，这个方法此时充当的是请求处理的方法，返回值会直接返回到前端；
    //只要是属于这个类里面的异常，都进入到改方法
    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> handler(Throwable e){

        JsonResult<Void> result = new JsonResult<>(e);
        //判断数据类型是否属于UserNameDuplicatedException类型的
        if(e instanceof UserNameDuplicatedException){
            //如果是/属于
            result.setState(4000);
            result.setMessage("用户名重复");
        }
        else if(e instanceof InstantiationError ){
            result.setState(5000);
            result.setMessage("插入时异常");
        }
        else if(e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户名不存在");
        }
        else if(e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("用户名密码不正确");
        }
        else if(e instanceof UpdateException){
            result.setState(5003);
            result.setMessage("更新数据时异常");
        }
        else if(e instanceof FileEmptyException){
            result.setState(6001);
            result.setMessage("上传的文件为空");
        }
        else if(e instanceof FileSizeException){
            result.setState(6002);
            result.setMessage("上传的文件大小超出限制");
        }
        else if(e instanceof FileStateException){
            result.setState(6003);
            result.setMessage("上传的文件状态异常");
        }
        else if(e instanceof FileTypeException){
            result.setState(6004);
            result.setMessage("上传的文件类型异常");
        }
        else if(e instanceof FileUploadIOException){
            result.setState(6005);
            result.setMessage("上传的文件读写时出现异常");
        }
        else if(e instanceof FileUploadIOException){
            result.setState(7001);
            result.setMessage("收货地址超出限制异常");
        }

        return result;
    }

    /**
     * 获取session中的用户ID
     * @param httpSession session对象
     * @return 当前登录的用户id
     */
    protected final Integer getUidFromSession(HttpSession httpSession){
        return Integer.valueOf(httpSession.getAttribute("uid").toString());
    }

    /**
     * 获取session中的用户名
     * @param httpSession session对象
     * @return 当前登录的用户id
     */
    protected final String getUsernameFromSession(HttpSession httpSession){
        return httpSession.getAttribute("username").toString();
    }

}
