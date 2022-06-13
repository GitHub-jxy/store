package com.jxy.store.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jxy.store.entity.TUser;
import com.jxy.store.service.MPUserService;
import com.jxy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/test")
public class MPControllerTest extends BaseController {

    @Autowired
    MPUserService mpUserService;

    @RequestMapping({"","/"})
    public JsonResult<TUser> tests(){
//        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(TUser::getUsername,"aaa");
//
////        queryWrapper.like(TUser::getUsername,"jxy");
//        TUser one = mpUserService.getOne(queryWrapper);
//        System.out.println(one);
//        return new JsonResult<TUser>(OK,one);
//        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(TUser::getUid,1);
//        TUser byId = mpUserService.getOne(queryWrapper);

        //修改
//        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(TUser::getUid,1);
//
//        TUser tUser = new TUser();
//        tUser.setEmail("www.com");
//        mpUserService.update(tUser,queryWrapper);
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TUser::getUsername,"aaa");
        TUser one = mpUserService.getOne(queryWrapper);
        one.setEmail("www.abc.com");
        mpUserService.updateById(one);

        return new JsonResult<TUser>(OK);
    }

    @RequestMapping("insert")
    public JsonResult<Void> insert(){
        TUser tUser = new TUser();
        tUser.setUsername("abc");
        tUser.setPassword("123");
        tUser.setPhone("176");
        mpUserService.insert(tUser);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("update")
    public JsonResult<Void> update(){
        //updateById
//        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(TUser::getUid,4);
//        TUser one = mpUserService.getOne(queryWrapper);
//        one.setUsername("abcdefg");
//        one.setPassword("321");
//        one.setPhone("888");
//        mpUserService.updateById(one);
        //update
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TUser::getUid,7);
        TUser tUser = new TUser();
        tUser.setUsername("abcdefg");
        tUser.setPassword("321");
        tUser.setPhone("888");
        mpUserService.update(tUser,queryWrapper);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("delete")
    public JsonResult<Void> delete(){
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TUser::getUid,4);
        TUser one = mpUserService.getOne(queryWrapper);
        mpUserService.removeById(one);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("selectAll")
    public JsonResult<List<TUser>> select(){
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();

        List<TUser> tUsers = mpUserService.selectAll();
        for (TUser tUser : tUsers) {
            System.out.println(tUser);
        }
        return new JsonResult<List<TUser>>(OK,tUsers);
    }

    @RequestMapping("selectCount")
    public JsonResult<Integer> selectCount(){
        Integer integer = mpUserService.selectCount();
        return new JsonResult<Integer>(OK,integer);
    }

}
