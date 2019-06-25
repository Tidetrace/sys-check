package com.ck.syscheck.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 配置控制类
 *
 * @author ck
 * @date 2019/6/24
 */
@Data
public class ConfigModel implements Serializable{

    private static final long serialVersionUID = 233806585652273322L;
    /**
     * ip
     */
    private String ip;
    /**
     * Cpu
     */
    private String cpu;
    /**
     * neicun
     */
    private String ddr;


}
