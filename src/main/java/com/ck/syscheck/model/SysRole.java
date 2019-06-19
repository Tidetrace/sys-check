package com.ck.syscheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 角色表
 * Create by ck on 2019/6/17
 */
@Data
public class SysRole {
    /**
     * 主键Id
     */
    private Integer id;

    /**
     * 角色名字
     */
    private String code;

    /**
     * 角色描述
     */
    private String name;

    /**
     * 状态   1:正常、9：禁用
     */
    private Short status;

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