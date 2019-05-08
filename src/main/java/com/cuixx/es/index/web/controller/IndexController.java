package com.cuixx.es.index.web.controller;

import com.cuixx.es.common.node.MenuNode;
import com.cuixx.es.shiro.ShiroKit;
import com.cuixx.es.sys.resource.service.IMenuService;
import com.cuixx.es.sys.user.entity.User;
import com.cuixx.es.sys.user.service.IUserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMenuService menuService;

    @GetMapping(value = "/") //spring3.2.2 bug see  http://jinnianshilongnian.iteye.com/blog/1831408
    public String index(Model model) {

        //获取菜单列表
        List<Integer> roleList = ShiroKit.getUser().getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "front/login";
        }
        List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);
        List<MenuNode> titles = MenuNode.buildTitle(menus);
//        titles = ApiMenuFilter.build(titles);

        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userService.getById(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "admin/index/index";
    }


    @RequestMapping(value = "/welcome")
    public String welcome(/*@CurrentUser User loginUser,*/ Model model) {

//        //未读消息
//        Long messageUnreadCount = messageService.countUnread(loginUser.getId());
//        model.addAttribute("messageUnreadCount", messageUnreadCount);
//
//        //最近3天的日历
//        model.addAttribute("calendarCount", calendarService.countRecentlyCalendar(loginUser.getId(), 2));

        return "admin/index/welcome";
    }





}
