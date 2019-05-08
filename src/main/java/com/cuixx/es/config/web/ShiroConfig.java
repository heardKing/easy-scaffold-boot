package com.cuixx.es.config.web;

import com.cuixx.es.shiro.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro权限管理配置
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        UserRealm realm = new UserRealm();
        realm.setCachingEnabled(true);
        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        /*
         * 配置shiro拦截器链
         *
         * anon  不需要认证
         * authc 需要认证
         * user  验证通过或RememberMe登录的都可以
         *
         * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的
         *
         * 顺序从上到下,优先级依次降低
         *
         * api开头的接口，走rest api鉴权，不走shiro鉴权
         *
         */
        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("/static/**", "anon");
        hashMap.put("/esApi/**", "anon");
        hashMap.put("/login", "anon");
        hashMap.put("/global/sessionError", "anon");
        hashMap.put("/kaptcha", "anon");
        hashMap.put("/**", "user");
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//        chainDefinition.addPathDefinition("/login.html", "authc"); // need to accept POSTs from the login form
//        chainDefinition.addPathDefinition("/logout", "logout");
        chainDefinition.addPathDefinitions(hashMap);
        return chainDefinition;
    }

    @ModelAttribute(name = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

}
