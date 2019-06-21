package com.ck.syscheck.service.Impl;

import com.ck.syscheck.dao.SysAccountLogMapper;
import com.ck.syscheck.model.SysAccountLog;
import com.ck.syscheck.service.SysAccountLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysAccountLogServiceImpl implements SysAccountLogService {

    @Resource
    private SysAccountLogMapper sysAccountLogMapper;

    @Override
    public int insert(SysAccountLog record) {
        return sysAccountLogMapper.insert(record);
    }
}
