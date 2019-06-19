package com.ck.syscheck.service;

import com.ck.syscheck.model.SysUserRole;

public interface SysUserRoleService {
    public SysUserRole findByUserId(String id);
}
