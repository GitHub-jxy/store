package com.jxy.store.mapper;

import com.jxy.store.entity.District;
import java.util.List;

/**
 * 省市区联动查询
 */
public interface DistrictMapper {

    /**
     * 根据父代号查询子级信息
     * @param parent
     * @return
     */
    List<District> findByParent(Integer parent);

}
