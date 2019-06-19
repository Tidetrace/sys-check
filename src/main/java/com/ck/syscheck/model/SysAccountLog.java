package com.ck.syscheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户账户操作日志
 * Create by ck on 2019/6/17
 */
@Data
public class SysAccountLog {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 日志名称 login -- register -- logout
     */
    private String logName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 是否执行成功 0失败 -- 1成功
     */
    private Byte succeed;

    /**
     * 详细消息
     */
    private String message;

    /**
     * 用户登录IP
     */
    private String ip;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}