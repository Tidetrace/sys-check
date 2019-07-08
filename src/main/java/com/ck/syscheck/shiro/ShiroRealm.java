package com.ck.syscheck.shiro;

import com.ck.syscheck.model.*;
import com.ck.syscheck.service.SysResourceService;
import com.ck.syscheck.service.SysRoleResourceService;
import com.ck.syscheck.service.SysUserRoleService;
import com.ck.syscheck.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysUserRoleService sysUserRoleService;


    /**
     * 处理授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("执行授权逻辑+" + principalCollection.toString());
        //给资源进行授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();
        //获取用户角色ID
        SysUserRole byUserId = sysUserRoleService.findByUserId(user.getUid());
        //此处必须要和配置文件里的授权保持一致
        authorizationInfo.addStringPermission("api:add");
        return authorizationInfo;
    }

    /**
     * 处理认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (StringUtils.isNotBlank(userName)) {
            SysUser user = sysUserService.list(userName);
            //检测是否有此用户
            if (user == null) {
                //  没有找到账号异常
                throw new UnknownAccountException("用户名或密码错误！");
            }
            if (!token.getUsername().equals(user.getUsername())) {
                return null;
            }
            if (user.getStatus().equals("0")) {
                throw new LockedAccountException("账号已被锁定,请联系管理员！");
            }
            // 获取盐值，即用户名
            ByteSource salt = ByteSource.Util.bytes("AaBbCc");
            // 将账户名，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());
            //返回密码
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
