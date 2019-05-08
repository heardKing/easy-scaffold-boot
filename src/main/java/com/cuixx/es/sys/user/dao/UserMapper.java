package com.cuixx.es.sys.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuixx.es.sys.user.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    User getByAccount(@Param("account") String account);
}
