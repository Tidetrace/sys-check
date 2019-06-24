package com.ck.syscheck.service;

import com.ck.syscheck.model.SysResource;

import java.util.Set;

public interface SysResourceService {
    public SysResource selectByPrimaryKey(Integer id);

    Set<SysResource> selectParentById(Integer parentId);
}
