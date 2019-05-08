package com.cuixx.es.front.web.controller;

import com.cuixx.es.common.web.controller.BaseController;
import com.cuixx.es.shiro.ShiroKit;
import com.cuixx.es.shiro.ShiroUser;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginFormController extends BaseController {

    @GetMapping(value = {"/{login:login;?.*}"})
    //spring3.2.2 bug see  http://jinnianshilongnian.iteye.com/blog/1831408
    public String loginForm() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "front/login";
        }
    }

    /**
     * 点击登录执行的动作
     */
    @PostMapping(value = "/login")
    public String loginVali() {
        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();
        String remember = super.getPara("remember");
        //验证验证码是否正确
//        if (KaptchaUtil.getKaptchaOnOff()) {
//            String kaptcha = super.getPara("kaptcha").trim();
//            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
//                throw new InvalidKaptchaException();
//            }
//        }
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        if ("on".equals(remember)) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }
        currentUser.login(token);
        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        super.getSession().setAttribute("username", shiroUser.getAccount());
        ShiroKit.getSession().setAttribute("sessionFlag", true);
        return REDIRECT + "/";
    }

}
