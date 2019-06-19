package com.ck.syscheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
/**
 * 用户角色表
 * Create by ck on 2019/6/17
 */
@Data
public class SysUserRole {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}