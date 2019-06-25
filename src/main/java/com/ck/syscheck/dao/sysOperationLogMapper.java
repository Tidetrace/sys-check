package com.ck.syscheck.dao;

import com.ck.syscheck.model.SysOperationLog;

public interface SysOperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperationLog record);

    int insertSelective(SysOperationLog record);

    SysOperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperationLog record);

    int updateByPrimaryKey(SysOperationLog record);
}