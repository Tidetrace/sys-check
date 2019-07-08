package com.ck.syscheck.service.Impl;

import com.ck.syscheck.dao.SysOperationLogMapper;
import com.ck.syscheck.model.SysOperationLog;
import com.ck.syscheck.service.SysOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysOperationServiceImpl implements SysOperationService {
    @Resource
    private SysOperationLogMapper sysOperationLogMapper;

    @Override
    public int insert(SysOperationLog record) {
        return sysOperationLogMapper.insert(record);
    }

    @Override
    public List<SysOperationLog> selectAll() {
        return sysOperationLogMapper.selectAll();
    }
}
