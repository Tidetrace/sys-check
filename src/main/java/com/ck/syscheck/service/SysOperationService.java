package com.ck.syscheck.service;

import com.ck.syscheck.model.SysOperationLog;

import java.util.List;

public interface SysOperationService {
    int insert(SysOperationLog record);

    List<SysOperationLog> selectAll();
}
