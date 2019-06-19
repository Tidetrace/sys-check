package com.ck.syscheck.service.Impl;

import com.ck.syscheck.dao.SysUserRoleMapper;
import com.ck.syscheck.model.SysUserRole;
import com.ck.syscheck.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper roleMapper;

    @Override
    public SysUserRole findByUserId(String id) {
        return roleMapper.findByUserId(id);
    }
}
