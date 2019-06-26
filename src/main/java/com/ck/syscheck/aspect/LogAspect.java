package com.ck.syscheck.aspect;

import com.ck.syscheck.annotate.Log;
import com.ck.syscheck.model.SysOperationLog;
import com.ck.syscheck.service.SysOperationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysOperationService sysOperationService;

    @Pointcut("@annotation(com.ck.syscheck.annotate.Log)")
    public void pointcut() { }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysOperationLog sysOperationLog = new SysOperationLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysOperationLog.setApi(logAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysOperationLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
//        if (args != null && paramNames != null) {
//            String params = "";
//            for (int i = 0; i < args.length; i++) {
//                params += "  " + paramNames[i] + ": " + args[i];
//            }
//            sysOperationLog.setMessage(params);
//        }
        // 模拟一个用户名
        sysOperationLog.setUserId("admin");
        sysOperationLog.setCreateTime(new Date());
        // 保存系统日志
        sysOperationService.insert(sysOperationLog);
    }
}