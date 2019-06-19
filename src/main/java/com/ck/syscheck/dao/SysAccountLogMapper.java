package com.ck.syscheck.dao;

import com.ck.syscheck.model.SysAccountLog;

public interface SysAccountLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAccountLog record);

    int insertSelective(SysAccountLog record);

    SysAccountLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAccountLog record);

    int updateByPrimaryKey(SysAccountLog record);
}