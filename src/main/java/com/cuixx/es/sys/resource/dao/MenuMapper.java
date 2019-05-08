package com.cuixx.es.sys.resource.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuixx.es.common.node.MenuNode;
import com.cuixx.es.sys.resource.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> getResUrlsByRoleId(@Param("roleId") Integer roleId);

    List<MenuNode> getMenusByRoleIds(List<Integer> roleList);
}
