package com.cuixx.es.sys.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_role")
@Data
public class Role {
    /**
     * 主键id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 序号
     */
    private Integer num;
    /**
     * 父角色id
     */
    private Integer pid;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 部门名称
     */
    private Integer deptid;
    /**
     * 提示
     */
    private String tips;
    /**
     * 保留字段(暂时没用）
     */
    private Integer version;

}
