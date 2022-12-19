package com.users.test.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * Logging aspect for inputs and outputs using AOP
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {


/**
 * Pointcuts before and after beans
 */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
                      " || within(@org.springframework.stereotype.Service *)" +
                      " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
    }


/**
 * Pointcuts before and after packages
 */
    @Pointcut("within(com.users.test..*)" +
                      " || within(com.users.test.service..*)" +
                      " || within(com.users.test.controller..*)")
    public void applicationPackagePointcut() {
    }

/**
 * After exception throwing log
 * @param joinPoint
 * @param e throwable
 */
    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getMessage() != null ? e.getMessage() : "NULL");
    }

/**
 *Method for logging in the pointcuts we created in the the beans and packages
 * @param joinPoint
 * @return
 * @throws Throwable
 */
    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw e;
        }
    }

}
