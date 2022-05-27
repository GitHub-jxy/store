package com.jxy.store.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    /**
     *  `created_user` varchar(20) DEFAULT NULL COMMENT '?????',
     *   `created_time` datetime DEFAULT NULL COMMENT '????ʱ?',
     *   `modified_user` varchar(20) DEFAULT NULL COMMENT '?޸??',
     *   `modified_time` datetime DEFAULT NULL COMMENT '?޸?ʱ?',
     */

    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
