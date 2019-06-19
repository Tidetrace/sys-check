package com.ck.syscheck.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/api")
@Api(value = "用户登录", tags = "用户登录！")
public class SYSUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 测试
     *
     * @return
     */
    @RequestMapping("/test")
    public ModelAndView test(ModelAndView modelAndView) {

        modelAndView.setViewName("/front/test");
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(ModelAndView modelAndView) {

        modelAndView.setViewName("/front/add");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(ModelAndView modelAndView) {

        modelAndView.setViewName("/front/update");
        return modelAndView;
    }


    @ApiOperation(value = "跳转到登录页面", notes = "跳转到登录页面！")
    @RequestMapping("/loginPage")
    public ModelAndView skipLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/pages-login");
        return modelAndView;
    }

    @ApiOperation(value = "跳转到注册页面", notes = "跳转到注册页面！")
    @RequestMapping("/registerPage")
    public ModelAndView skipRegister() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/pages-register");
        return modelAndView;
    }

    @ApiOperation(value = "跳转到未授权页面", notes = "跳转到未授权页面！")
    @RequestMapping("/unAuth")
    public ModelAndView skipUnAuth() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/pages-404");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录认证",httpMethod = "POST", notes = "用户输入账密进行登录认证！")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",required = true,value = "用户名"),
            @ApiImplicitParam(name = "username",required = true,value = "密码")

    })
    public ModelAndView login(@RequestParam(name = "username", required = true, defaultValue = "") String username,
                              @RequestParam(name = "password", required = true, defaultValue = "") String password,
                              Model model) {
        ModelAndView modelAndView = new ModelAndView();
        //1、获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //3、执行登录方法
        try {
            //登录成功
            subject.login(token);
            modelAndView.setViewName("front/test");
            return modelAndView;
        } catch (UnknownAccountException e) {
            logger.info("登录失败" + "用户名不存在");
            model.addAttribute("msg", "用户名不存在！");
            model.addAttribute("flag", false);
            modelAndView.setViewName("front/pages-login");
        } catch (IncorrectCredentialsException e) {
            logger.info("登录失败" + "密码错误");
            model.addAttribute("msg", "密码错误！");
            model.addAttribute("flag", false);
            modelAndView.setViewName("front/pages-login");
        }
        return modelAndView;

    }

}
