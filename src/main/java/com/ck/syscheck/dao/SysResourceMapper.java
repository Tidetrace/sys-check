package com.ck.syscheck.dao;

import com.ck.syscheck.model.SysResource;

import java.util.Set;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    Set<SysResource> selectParentById(Integer parentId);
}