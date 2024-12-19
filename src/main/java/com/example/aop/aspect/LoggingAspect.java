package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.example.aop.service.*.*(..))")
    public Object atTarget(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("{} 메소드 시작", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("{} 메소드 종료 :: {}", joinPoint.getSignature(), executionTime + "ms");
        return result;
    }

//    @Pointcut("execution(* com.example.aop.service.*.*(..)) && @target(com.example.aop.annotation.ClassAOP)")
//    public void serviceMethods() {}
//
//    @Pointcut("within(com.example.aop.service.*)")
//    public void within() {}
//
//    @Pointcut("@annotation(com.example.aop.annotation.ClassAOP)")
//    public void atTarget() {}
//
//    @Pointcut("execution(* com.example.aop.service.*.*(..)) && args(arg)")
//    public void methodWithArgs(String arg) {}
//
//    @Pointcut("execution(* com.example.aop.service.*.*(..))")
//    public void methodPackage() {}
//
//    @Pointcut("execution(* com.example.aop.service.*.*(..))")
//    public void serviceMethods() {}
//
//    @Around("serviceMethods()")
//    public Object atTarget(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("{} 메소드 시작", joinPoint.getSignature());
//        Object result = joinPoint.proceed();
//        log.info("{} 메소드 종료", joinPoint.getSignature());
//        return result;
//    }
//
//    @Before("serviceMethods()")
//    public void logBefore(JoinPoint joinPoint) {
//        log.info("{} 실행  ", joinPoint.getSignature().getName());
//    }

//    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result) {
//        log.info("{} 실행 정상 종료. Result: {}", joinPoint.getSignature(), result);
//    }
//
//    @After("serviceMethods()")
//    public void logAfter(JoinPoint joinPoint) {
//        log.info("{} 종료  ", joinPoint.getSignature().getName());
//    }
//
//    @AfterThrowing(pointcut = "serviceMethods()", throwing = "error")
//    public void afterThrowingMethod(JoinPoint joinPoint, Throwable error) {
//        log.info("{} 실행 예외 발생. error: {}", joinPoint.getSignature(), error);
//    }
}
