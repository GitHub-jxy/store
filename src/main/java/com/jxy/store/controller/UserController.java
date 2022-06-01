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

import javax.servlet.http.HttpSession;

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
        return new JsonResult<Void>(OK);

    }

    @RequestMapping("login")
    public JsonResult<User> login(User user, HttpSession session){
        User data = iUserService.login(user.getUsername(), user.getPassword());
        //向session对象中完成数据的绑定（全局的）
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());
        //暂时没使用，需要在BaseController里面写上对应的session
        session.setAttribute("password",data.getPassword());
        session.setAttribute("avatar",data.getAvatar());
//        System.out.println(getUidFromSession(session));
        return new JsonResult<User>(OK,data);
    }
}
