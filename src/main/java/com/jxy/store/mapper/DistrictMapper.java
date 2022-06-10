package com.jxy.store.mapper;

import com.jxy.store.entity.District;
import java.util.List;

/**
 * 省市区联动查询
 */
public interface DistrictMapper {

    /**
     * 根据父代号查询子级信息
     * 查询所有的省信息
     * @param parent
     * @return
     */
    List<District> findByParent(String parent);

    /**
     * 根据查询出来的所有市，来向下查询
     * 查询该省下的所有市信息
     * @param code
     * @return
     */
    String findByCode(String code);


}
