package com.jxy.store.controller;

import com.jxy.store.entity.User;
import com.jxy.store.service.impl.ex.IUserService;
import com.jxy.store.service.impl.ex.ex.InsertException;
import com.jxy.store.service.impl.ex.ex.ServiceException;
import com.jxy.store.service.impl.ex.ex.UserNameDuplicatedException;
import com.jxy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    //没有BaseController之前的写法
//    @RequestMapping("reg")
//    public JsonResult<Void> reg(User user){
//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            iUserService.reg(user);
//            result.setCode(200);
//            result.setMessage("注册成功");
//        } catch (UserNameDuplicatedException e) {
//            result.setCode(4000);
//            result.setMessage("用户名重复");
//        } catch (InsertException e) {
//            result.setCode(4500);
//            result.setMessage("插入时异常");
//        }
//        return result;
//    }
    //继承BaseController后的写法
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        iUserService.reg(user);
        return new JsonResult<>(OK);

    }
}
