package com.jxy.store.mapper;

import com.jxy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户模块持久层接口
 */
@Repository
public interface UserMapper {
    /**
     * 插入用户数据
     * 通过返回的值/受影响的行数，来判断是否成功
     * @param user
     * @return
     */
    Integer insert (User user);

    /**
     * 根据用户名来查询改用户是否存在
     * @param name
     * @return
     */
    User findByUserName(String name);
}
