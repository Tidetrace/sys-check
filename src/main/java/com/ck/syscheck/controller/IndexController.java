package com.ck.syscheck.controller;

import com.ck.syscheck.annotate.Log;
import com.ck.syscheck.model.*;
import com.ck.syscheck.service.*;
import com.ck.syscheck.utils.ResultInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 主页
 *
 * @author ck
 * @date 2019/6/20
 */
@RestController
@RequestMapping("/home")
@Api(value = "主页信息", tags = "主页信息！")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Integer PAGESIZE = 10;

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SysRoleResourceService sysRoleResourceService;

    @Resource
    private SysResourceService sysResourceService;

    @Resource
    private SysOperationService sysOperationService;

    @Log("跳转到主页--index")
    @GetMapping("/index")
    public ModelAndView update(ModelAndView modelAndView) {
        logger.error("成功进入首页");

        //1、获取Subject
        Subject subject = SecurityUtils.getSubject();
        //3、执行登录方法
        //登录成功
        SysUser user = (SysUser) subject.getPrincipal();
        //将资源存到List集合中
        Set<SysResource> set = new LinkedHashSet<>();
        //获取用户角色ID
        SysUserRole byUserId = sysUserRoleService.findByUserId(user.getUid());
        if (byUserId != null) {
            //获取用户资源ID
            Set<SysRoleResource> byRoleId = sysRoleResourceService.findByRoleId(byUserId.getRoleId());
            if (byRoleId != null) {
                for (SysRoleResource resourceId : byRoleId) {
                    //遍历角色资源表获取该角色对应的资源
                    SysResource sysResource = sysResourceService.selectByPrimaryKey(resourceId.getResourceId());
                    if (sysResource != null) {
                        //根据父级ID查询
                        Set<SysResource> resource = sysResourceService.selectParentById(sysResource.getParentId());
                        if (resource != null) {
                            sysResource.setSubmenu(resource);
                        }
                        set.add(sysResource);
                    }

                }
            }
        }

        modelAndView.addObject("list", set);
        modelAndView.setViewName("/front/index");
        return modelAndView;
    }

//    @Log("在主页展示用户登录日志")
//    @GetMapping("/list")
//    @ApiOperation(value = "将日志信息在首页展示")
//    public PageInfo<SysOperationLog> list(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum, Model model) {
//        PageHelper.startPage(pageNum, PAGESIZE);
//        List<SysOperationLog> logList = sysOperationService.selectAll();
//        PageInfo<SysOperationLog> pageInfo = new PageInfo<>(logList);
//        model.addAttribute("logList", logList);
//        model.addAttribute("page", pageInfo);
//        return pageInfo;
//    }

    @Log("在主页展示用户登录日志")
    @GetMapping("/list")
    @ApiOperation(value = "将日志信息在首页展示")
    public ResultInfo<List<SysOperationLog>> list(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum, Model model) {
        logger.error("当前页为{}", pageNum);
        List<SysOperationLog> logList = sysOperationService.selectAll();
        return ResultInfoUtil.success(logList);
    }
}
