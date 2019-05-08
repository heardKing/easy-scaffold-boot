package com.cuixx.es.sys.organization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_dept")
@Data
public class Dept {
    /**
     * 主键id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 排序
     */
    private Integer num;
    /**
     * 父部门id
     */
    private Integer pid;
    /**
     * 父级ids
     */
    private String pids;
    /**
     * 简称
     */
    private String simplename;
    /**
     * 全称
     */
    private String fullname;
    /**
     * 提示
     */
    private String tips;
    /**
     * 版本（乐观锁保留字段）
     */
    private Integer version;

}
