package com.ck.syscheck.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ck.syscheck.shiro.ShiroRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 创建ShiroFilterFactoryBean
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * 常用过滤器
         *      anon:无需认证（登录）就可以访问
         *      authc:必须认证才可以访问
         *      user：如果使用RememberMe的功能，可以直接访问
         *      perms:该资源必须得到资源权限才可以访问
         *      role：该资源必须得到角色权限才可以访问
         */

        //登录的url
        shiroFilterFactoryBean.setLoginUrl("/api/loginPage");
        // 未授权url
        shiroFilterFactoryBean.setUnauthorizedUrl("/api/unAuth");
        // 登录成功后跳转的url
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //注意此处要使用LinkenHashMap
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/", "authc");
        // 定义filterChain，静态资源不拦截
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/img/**", "anon");
        //放行某些个请求
        filterMap.put("/api/test", "anon");
        filterMap.put("/api/login", "anon");
        //授权过滤器，如果未授权会跳转到相应的页面
        filterMap.put("/api/add", "perms[api:add]");
        // 除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
//        filterMap.put("/api/*", "authc");
//        filterMap.put("/home/*","authc");
//        filterMap.put("/config/*","authc");

        // 配置退出过滤器，其中具体的退出代码 Shiro已经替我们实现了
        filterMap.put("/logout", "logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /***
     * 创建DefaultWebSecurityManager
     * @param shiroRealm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(shiroRealm);
        //记住我
        securityManager.setRememberMeManager(rememberMeManager());
        //缓存管理
        securityManager.setCacheManager(getEhCacheManager());
        return securityManager;
    }


    /**
     * 创建Relm
     *
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }


    /**
     * 配置ShiroDialect，用于整合shiro和Thymeleaf标签配合使用
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


    /**
     * cookie对象
     * @return
     */
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**
     * cookie管理对象
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * 注入Ehcache缓存
     * @return
     */
    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return ehCacheManager;
    }
}
