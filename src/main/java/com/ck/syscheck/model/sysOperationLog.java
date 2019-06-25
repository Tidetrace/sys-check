package com.ck.syscheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户操作日志主键
 * Create by ck on 2019/6/17
 */
@Data
public class SysOperationLog implements Serializable {

    private static final long serialVersionUID = 8147899229715719433L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 用户id
     */
    private String userId;

    /**
     * api名称
     */
    private String api;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 是否执行成功 0失败 -- 1成功
     */
    private Byte succeed;

    /**
     * 详细备注
     */
    private String message;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}