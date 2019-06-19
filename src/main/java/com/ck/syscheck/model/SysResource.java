package com.ck.syscheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 资源表
 * Create by ck on 2019/6/17
 */
@Data
public class SysResource {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String code;

    /**
     * 资源描述
     */
    private String name;

    /**
     * 父资源编码->菜单
     */
    private Integer parentId;

    /**
     * 访问地址URL
     */
    private String uri;

    /**
     * 类型 1:菜单menu 2:资源element(rest-api) 3:资源分类
     */
    private Short type;

    /**
     * 访问方式 GET POST PUT DELETE PATCH
     */
    private String method;

    /**
     * 图标
     */
    private String icon;

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