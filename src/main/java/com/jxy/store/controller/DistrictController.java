package com.jxy.store.controller;

import com.jxy.store.entity.District;
import com.jxy.store.service.DistrictService;
import com.jxy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("district")
public class DistrictController extends BaseController {

    @Autowired
    DistrictService districtService;

    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParents(String parent){
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<List<District>>(OK,data);
    }

}
