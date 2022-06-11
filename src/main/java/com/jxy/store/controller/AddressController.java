package com.jxy.store.controller;


import com.jxy.store.entity.Address;
import com.jxy.store.service.AddressService;
import com.jxy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController extends BaseController {

    @Autowired
    AddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Address> insertAddress(HttpSession session,Address address){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid,username,address);
        return new JsonResult<Address>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<Address>> selectAddressByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> list = addressService.selectAddressByUid(uid);
        return new JsonResult<List<Address>>(OK,list);
    }

}
