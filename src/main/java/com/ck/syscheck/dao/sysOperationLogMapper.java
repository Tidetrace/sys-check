package com.ck.syscheck.dao;

import com.ck.syscheck.model.SysOperationLog;

import java.util.List;

public interface SysOperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperationLog record);

    int insertSelective(SysOperationLog record);

    SysOperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperationLog record);

    int updateByPrimaryKey(SysOperationLog record);

    List<SysOperationLog> selectAll();
}