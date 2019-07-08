package com.ck.syscheck.model;

import lombok.Data;

import java.io.Serializable;

/**
  *  结果集合
  * @author ck
  * @date 2019/6/26
  */
@Data
public class ResultMsg implements Serializable{


    private static final long serialVersionUID = -8285899751143133388L;
    /**
     * 错误信息
     */
    private String msg;

    /**
     * flag
     */
    private Boolean flag;
}
