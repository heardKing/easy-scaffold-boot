package com.cuixx.es.shiro;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 */
@Data
public class ShiroUser implements Serializable {

    public Integer id;          // 主键ID
    public String account;      // 账号
    public String name;         // 姓名
    public Integer deptId;      // 部门id
    public List<Integer> roleList; // 角色集
    public String deptName;        // 部门名称
    public List<String> roleNames; // 角色名称集

}
