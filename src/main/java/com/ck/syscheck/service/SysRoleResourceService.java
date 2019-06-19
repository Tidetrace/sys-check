package com.ck.syscheck.service;

import com.ck.syscheck.model.SysRoleResource;

import java.util.List;

public interface SysRoleResourceService {
    public List<SysRoleResource> findByRoleId(Integer id);
}
