package com.example.aop.aspect;

import com.example.aop.annotation.LogAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Instant;
import java.time.Duration;

@Aspect
@Component
public class LogAspectHandler {

    @Pointcut("@annotation(com.example.aop.annotation.LogAspect)")
    public void logPointCut() {}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        var beginTime = Instant.now();
        // 执行方法
        var result = point.proceed();
        // 执行时长(毫秒)
        var duration = Duration.between(beginTime, Instant.now());
        // 保存日志
        saveLog(point, duration.toMillis());
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long timeMillis) {
        var signature = (MethodSignature) joinPoint.getSignature();
        var method = signature.getMethod();
        var logAspect = method.getAnnotation(LogAspect.class);
        
        var description = logAspect.description();
        var key = logAspect.key();
        var name = logAspect.name();
        
        // 获取请求的方法名
        var className = joinPoint.getTarget().getClass().getName();
        var methodName = signature.getName();
        
        // 打印日志信息
        System.out.println("------ 日志记录开始 ------");
        System.out.println("方法执行前：" + className + "." + methodName + "()");
        System.out.println("方法描述：" + description);
        System.out.println("键值(Key)：" + key);
        System.out.println("名称(Name)：" + name);
        System.out.println("方法执行后：" + className + "." + methodName + "()");
        System.out.println("执行时长：" + timeMillis + "ms");
        System.out.println("------ 日志记录结束 ------");
    }
} 