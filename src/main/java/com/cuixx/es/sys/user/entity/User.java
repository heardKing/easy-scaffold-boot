package com.cuixx.es.sys.user.entity;

import com.cuixx.es.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User extends BaseEntity<Integer> {

    private String username;

    private String email;

    private String mobilePhoneNumber;

    /**
     * 使用md5(username + original password + salt)加密存储
     */
    private String password;

    /**
     * 加密密码时使用的种子
     */
    private String salt;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 系统用户的状态
     */
    private String status;

    /**
     * 是否是管理员
     */
    private Boolean admin = false;

    /**
     * 逻辑删除flag
     */
    private Boolean deleted = Boolean.FALSE;
}
