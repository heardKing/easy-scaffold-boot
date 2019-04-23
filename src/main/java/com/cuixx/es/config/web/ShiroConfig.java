package com.cuixx.es.config.web;

import com.cuixx.es.shiro.realm.UserRealm;
import com.cuixx.es.shiro.session.OnlineSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro权限管理配置
 */
@Configuration
public class ShiroConfig {

    /**
     * 项目自定义的Realm
     */
    @Bean
    public UserRealm shiroDbRealm() {
        UserRealm userRealm = new UserRealm();
        //用切面缓存代理了 此处就不缓存了
        userRealm.setAuthenticationCachingEnabled(false);
        userRealm.setAuthorizationCachingEnabled(false);
        return userRealm;
    }

    @Bean
    public SessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }

    @Value("${shiro.uid.cookie.name}")
    private String cookieName;
    @Value("${shiro.uid.cookie.maxAge}")
    private int cookieMaxAge;
    @Bean
    public Cookie sessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie(cookieName);
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(cookieMaxAge);
        return simpleCookie;
    }

    @Value("${shiro.uid.rememeberMe.cookie.name}")
    private String rememeberName;
    @Value("${shiro.uid.rememeberMe.cookie.maxAge}")
    private int rememeberMaxAge;
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie(rememeberName);
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(rememeberMaxAge);//7天
        return simpleCookie;
    }

    @Value("${shiro.active.session.cacheName}")
    private String activeSessionsCacheName;
    @Bean
    public OnlineSessionDAO onlineSessionDAO(SessionIdGenerator sessionIdGenerator){
        OnlineSessionDAO onlineSessionDAO = new OnlineSessionDAO();
        onlineSessionDAO.setSessionIdGenerator(sessionIdGenerator);
        onlineSessionDAO.setActiveSessionsCacheName(activeSessionsCacheName);
        return onlineSessionDAO;
    }

}
