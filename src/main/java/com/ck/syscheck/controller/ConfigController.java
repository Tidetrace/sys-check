package com.ck.syscheck.controller;

import com.ck.syscheck.model.ConfigModel;
import com.ck.syscheck.utils.CPUMonitorCalc;
import com.ck.syscheck.utils.IPUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;

/**
 * 配置控制器
 *
 * @author ck
 * @date 2019/6/24
 */
@RestController
@RequestMapping("/config")
@Api(value = "配置控制器", tags = "获取当前相关设备信息！")
public class ConfigController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "获取CPU相关信息", notes = "实时获取CPU相关信息！")
    @RequestMapping("/context")
    public ConfigModel skipRegister(HttpServletRequest request) {
//        logger.info("--------------获取当qian设备信息----------------------");
//        String ipAddr = IPUtil.getIpAddr(request);
//        logger.error(""+CPUMonitorCalc.getInstance().getProcessCpu());
//        Double processCpu = CPUMonitorCalc.getInstance().getProcessCpu();
//        String cpu =new DecimalFormat("#.00").format(processCpu);
//        ConfigModel configModel = new ConfigModel();
//        configModel.setCpu(cpu);
//        configModel.setIp(ipAddr);
//        logger.info("获取当前设备信息CPU: "+processCpu);
//        return configModel;
        return null;

    }
}
