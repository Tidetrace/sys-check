package com.ck.syscheck.service;

import com.ck.syscheck.model.SysUser;

public interface SysUserService {
    SysUser list(String username);
}
