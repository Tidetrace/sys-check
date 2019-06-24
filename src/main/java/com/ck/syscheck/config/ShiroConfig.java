package com.ck.syscheck.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ck.syscheck.shiro.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
        //注意此处要使用LinkenHashMap
        Map<String, String> filterMap = new LinkedHashMap<>();
        //放行某些个请求
        filterMap.put("/api/test", "anon");
        filterMap.put("/api/login", "anon");
        //授权过滤器，如果未授权会跳转到相应的页面
        filterMap.put("/api/add", "perms[api:add]");
        //通配符匹配所有
        filterMap.put("/api/*", "authc");
        filterMap.put("/config/*","authc");
        // 配置退出过滤器，其中具体的退出代码 Shiro已经替我们实现了
//        filterMap.put("/api/logout","logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //修改调整后的登录页面
        shiroFilterFactoryBean.setLoginUrl("/api/loginPage");
        //修改调整后的未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/api/unAuth");
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

}
