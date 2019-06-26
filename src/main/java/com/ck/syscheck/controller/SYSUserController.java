package com.ck.syscheck.controller;

import com.ck.syscheck.annotate.Log;
import com.ck.syscheck.model.*;
import com.ck.syscheck.service.*;
import com.ck.syscheck.utils.IPUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 处理用户登录
 *
 * @author ck
 * @date 2019/6/20
 */
@RestController
@RequestMapping("/api")
@Api(value = "用户登录", tags = "用户登录！")
public class SysUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SysRoleResourceService sysRoleResourceService;

    @Resource
    private SysResourceService sysResourceService;
    @Resource
    private SysAccountLogService sysAccountLogService;

    /**
     * @return 测试
     */
    @Log("测试test")
    @RequestMapping("/test")
    public ModelAndView test(ModelAndView modelAndView) {

        modelAndView.setViewName("/front/test");
        return modelAndView;
    }

    @Log("添加add")
    @RequestMapping("/add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/front/add");
        return modelAndView;
    }

    @Log("更新Update")
    @RequestMapping("/update")
    public ModelAndView update(ModelAndView modelAndView) {
        modelAndView.setViewName("/front/update");
        return modelAndView;
    }

    @Log("跳转到登录页面")
    @ApiOperation(value = "跳转到登录页面", notes = "跳转到登录页面！")
    @RequestMapping("/loginPage")
    public ModelAndView skipLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/pages-login");
        return modelAndView;
    }

    @Log("跳转到注册页面")
    @ApiOperation(value = "跳转到注册页面", notes = "跳转到注册页面！")
    @RequestMapping("/registerPage")
    public ModelAndView skipRegister() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/pages-register");
        return modelAndView;
    }

    @Log("跳转到未授权页面")
    @ApiOperation(value = "跳转到未授权页面", notes = "跳转到未授权页面！")
    @RequestMapping("/unAuth")
    public ModelAndView skipUnAuth() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/pages-404");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录认证", httpMethod = "POST", notes = "用户输入账密进行登录认证！")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", required = true, value = "用户名"),
            @ApiImplicitParam(name = "password", required = true, value = "密码")

    })
    @RequiresPermissions(value = "/api/login")
    public ResultMsg login(@RequestParam(name = "username", required = true, defaultValue = "") String username,
                           @RequestParam(name = "password", required = true, defaultValue = "") String password,
                           Boolean rememberMe, HttpServletRequest request, Model model) {
        ResultMsg res = new ResultMsg();
        //1、获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        logger.error("&&&&&&&&&&&&&&&"+rememberMe);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        //获取用户登录IP
        String ip = IPUtil.getIpAddr(request);
        logger.info("ip地址为：" + ip);
        //3、执行登录方法
        try {
            //登录成功
            subject.login(token);
            //记录日志
            sysAccountLogService.insert(getAccountLogInfo(username, ip, "用户登录成功！", (byte) 1));
            res.setFlag(true);
            res.setMsg("success");
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在！");
            //记录日志
            sysAccountLogService.insert(getAccountLogInfo(username, ip, "用户名不存在，登录失败！", (byte) 0));
            res.setFlag(false);
            res.setMsg("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误，登录失败！");
            //记录日志
            sysAccountLogService.insert(getAccountLogInfo(username, ip, "密码错误，登录失败！", (byte) 0));
            res.setFlag(false);
            res.setMsg("密码错误，登录失败！");

        }
        return res;
    }

    private SysAccountLog getAccountLogInfo(String username, String ip, String meg, Byte success) {
        SysAccountLog sysAccountLog = new SysAccountLog();
        sysAccountLog.setIp(ip);
        sysAccountLog.setUsername(username);
        sysAccountLog.setLogName("用户登录日志");
        sysAccountLog.setCreateTime(new Date());
        sysAccountLog.setSucceed(success);
        sysAccountLog.setMessage(meg);
        return sysAccountLog;
    }
}
