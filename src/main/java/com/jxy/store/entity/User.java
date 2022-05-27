package com.jxy.store.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User extends BaseEntity implements Serializable {
    /**
     *  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
     *   `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
     *   `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
     *   `salt` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐值',
     *   `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
     *   `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮箱',
     *   `gender` int DEFAULT NULL COMMENT '性别:0-女，1-男',
     *   `avatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
     *   `is_delete` int DEFAULT NULL COMMENT '是否删除：0-未删除，1-已删除',
     */

    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;

}
