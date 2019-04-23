package com.cuixx.es.shiro.factory;


import com.cuixx.es.common.utils.SpringContextHolder;
import com.cuixx.es.shiro.ShiroUser;
import com.cuixx.es.sys.user.entity.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {

//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private MenuMapper menuMapper;

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public User user(String account) {

        User user = new User();

//        // 账号不存在
//        if (null == user) {
//            throw new CredentialsException();
//        }
//        // 账号被冻结
//        if (user.getStatus() != ManagerStatus.OK.getCode()) {
//            throw new LockedAccountException();
//        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());
//        shiroUser.setAccount(user.getAccount());
//        shiroUser.setDeptId(user.getDeptid());
//        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));
//        shiroUser.setName(user.getName());
//
//        Integer[] roleArray = Convert.toIntArray(user.getRoleid());
//        List<Integer> roleList = new ArrayList<Integer>();
//        List<String> roleNameList = new ArrayList<String>();
//        for (int roleId : roleArray) {
//            roleList.add(roleId);
//            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
//        }
//        shiroUser.setRoleList(roleList);
//        shiroUser.setRoleNames(roleNameList);

        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
//        return menuMapper.getResUrlsByRoleId(roleId);
        return Collections.emptyList();
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
//        return ConstantFactory.me().getSingleRoleTip(roleId);
        return null;
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();

        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }

}
