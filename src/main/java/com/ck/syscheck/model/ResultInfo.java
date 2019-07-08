package com.ck.syscheck.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 *
 * @author ck
 * @date 2019/7/1
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = 409897222541150194L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}