package com.ck.syscheck.service.Impl;

import com.ck.syscheck.dao.SysRoleResourceMapper;
import com.ck.syscheck.model.SysRoleResource;
import com.ck.syscheck.service.SysRoleResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
    @Resource
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Override
    public Set<SysRoleResource> findByRoleId(Integer id) {
        return sysRoleResourceMapper.findByRoleId(id);
    }
}
