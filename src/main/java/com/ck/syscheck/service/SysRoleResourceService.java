package com.ck.syscheck.service;

import com.ck.syscheck.model.SysRoleResource;

import java.util.Set;

public interface SysRoleResourceService {
    public Set<SysRoleResource> findByRoleId(Integer id);
}
