package com.ck.syscheck.service.Impl;

import com.ck.syscheck.dao.SysUserMapper;
import com.ck.syscheck.model.SysUser;
import com.ck.syscheck.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;

    @Override
    public SysUser list(String username) {
        return userMapper.list(username);
    }
}
