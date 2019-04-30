package com.cuixx.es.sys.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuixx.es.sys.user.dao.UserMapper;
import com.cuixx.es.sys.user.entity.User;
import com.cuixx.es.sys.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
