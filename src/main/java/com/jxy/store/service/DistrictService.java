package com.jxy.store.service;

import com.jxy.store.entity.District;

import java.util.List;

public interface DistrictService {

    /**
     * 根据父代号查询子级信息
     * @param parent
     * @return
     */
    List<District> getByParent(String parent);

    String getByCode(String code);
}
