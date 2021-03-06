package com.ck.syscheck.service.Impl;

import com.ck.syscheck.dao.SysResourceMapper;
import com.ck.syscheck.model.SysResource;
import com.ck.syscheck.service.SysResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Override
    public SysResource selectByPrimaryKey(Integer resourceId) {
        return sysResourceMapper.selectByPrimaryKey(resourceId);
    }


    @Override
    public Set<SysResource> selectParentById(Integer parentId) {
        return sysResourceMapper.selectParentById(parentId);
    }
}
