package com.jxy.store.service.impl;

import com.jxy.store.entity.District;
import com.jxy.store.mapper.DistrictMapper;
import com.jxy.store.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);

        //为避免资源及网络带宽浪费，把无用的信息继续剔除
        for (District district : list) {
            district.setId(null);
            district.setParent(null);
        }

        return list;
    }

    @Override
    public String getByCode(String code) {
        String name = districtMapper.findByCode(code);
        return name;
    }

}
