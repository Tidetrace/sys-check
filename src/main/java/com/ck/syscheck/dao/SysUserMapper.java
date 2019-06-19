package com.ck.syscheck.dao;

import com.ck.syscheck.model.SysUser;

import java.util.HashMap;

public interface SysUserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser list(String username);
}