package com.cuixx.es.sys.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cuixx.es.common.node.MenuNode;
import com.cuixx.es.sys.resource.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {
    List<MenuNode> getMenusByRoleIds(List<Integer> roleList);
}
