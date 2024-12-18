package com.example.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut 정의: 특정 패키지의 모든 메서드
    @Pointcut("execution(* com.example.aop.service.*.*(..))")
    public void serviceMethods() {}

    // 메서드 실행 전에 로깅
    @Before("serviceMethods()")
    public void logBefore() {
        logger.info("A method in the service layer is about to be executed.");
    }

    // 메서드 실행 후 반환값 로깅
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(Object result) {
        logger.info("A method in the service layer was executed successfully. Result: {}", result);
    }
}
