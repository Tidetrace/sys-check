package com.ck.syscheck.dao;

import com.ck.syscheck.model.SysRoleResource;

import java.util.Set;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    SysRoleResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);

    Set<SysRoleResource> findByRoleId(Integer id);
}