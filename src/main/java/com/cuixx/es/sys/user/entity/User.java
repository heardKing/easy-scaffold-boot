package com.cuixx.es.sys.user.entity;

import com.cuixx.es.common.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
