package com.ck.syscheck.dao;

import com.ck.syscheck.model.SysRole;
import com.ck.syscheck.model.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    SysUserRole findByUserId(String id);
}