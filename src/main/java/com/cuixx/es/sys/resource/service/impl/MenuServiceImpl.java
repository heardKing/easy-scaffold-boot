package com.cuixx.es.sys.resource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuixx.es.common.node.MenuNode;
import com.cuixx.es.sys.resource.dao.MenuMapper;
import com.cuixx.es.sys.resource.entity.Menu;
import com.cuixx.es.sys.resource.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Override
    public List<MenuNode> getMenusByRoleIds(List<Integer> roleList) {
        return this.baseMapper.getMenusByRoleIds(roleList);
    }
}
