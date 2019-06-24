package com.ck.syscheck.model;

import lombok.Data;

/**
 * 配置控制类
 *
 * @author ck
 * @date 2019/6/24
 */
@Data
public class ConfigModel {
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
