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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleResourceService sysRoleResourceService;

    @Autowired
    private SysResourceService sysResourceService;



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
        if (byUserId != null) {
            //获取用户资源ID
            List<SysRoleResource> byRoleId = sysRoleResourceService.findByRoleId(byUserId.getRoleId());
            if (byRoleId != null) {
                //遍历获取该角色对应的权限
                for (SysRoleResource resourceId : byRoleId) {
                    SysResource sysResource = sysResourceService.selectByPrimaryKey(resourceId.getResourceId());
                    if (sysResource != null) {
//                        //将请求添加到author里面
//                        authorizationInfo.addStringPermission(sysResource.getUri());
                    }

                }
            }

        }

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
        logger.info("执行认证逻辑+" + authenticationToken.toString());
        //模拟数据库操作
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (StringUtils.isNotBlank(token.getUsername())) {
            SysUser user = sysUserService.list(token.getUsername());
            if (user != null) {
                if (!token.getUsername().equals(user.getUsername())) {
                    return null;
                }
                //返回密码
                return new SimpleAuthenticationInfo(user, user.getPassword(), "");
            }
        }
        return null;
    }
}
