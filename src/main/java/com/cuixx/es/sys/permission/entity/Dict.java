package com.cuixx.es.sys.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dict {
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
     * 父级字典
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;
    /**
     * 提示
     */
    private String tips;
}
