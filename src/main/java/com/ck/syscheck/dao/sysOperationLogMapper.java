package com.ck.syscheck.dao;

import com.ck.syscheck.model.sysOperationLog;

public interface sysOperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(sysOperationLog record);

    int insertSelective(sysOperationLog record);

    sysOperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(sysOperationLog record);

    int updateByPrimaryKey(sysOperationLog record);
}