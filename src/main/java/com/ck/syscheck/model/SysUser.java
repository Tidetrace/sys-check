package com.ck.syscheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
/**
 * 用户表
 * Create by ck on 2019/6/17
 */
@Data
public class SysUser {
    /**
     * 主键ID
     */
    private String uid;

    /**
     * 昵称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 加盐
     */
    private String salt;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号--唯一的
     */
    private String phone;

    /**
     * 邮箱--唯一的
     */
    private String email;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 账户状态(1.正常 2.锁定 3.删除 4.非法)
     */
    private Byte status;

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

    /**
     * 创建来源(1.web 2.android 3.ios 4.win 5.macos 6.ubuntu)
     */
    private Byte createWhere;


}