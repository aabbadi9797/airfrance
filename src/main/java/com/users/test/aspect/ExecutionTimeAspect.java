package com.users.test.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Execution Time aspect for logging execution time of methods
 */
@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {

/**
 * Log execution time for methods
 * @param joinPoint
 * @return Object
 * @throws Throwable
 */
@Around("@annotation(com.users.test.annotation.LogExecutionTime)")
public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    final StopWatch stopWatch = new StopWatch();
    
    stopWatch.start();
    
    Object proceed = joinPoint.proceed();
    
    stopWatch.stop();
    
    log.info("\"{}\" executed in {} ms", joinPoint.getSignature(), stopWatch.getTotalTimeMillis());
    
    return proceed;
}

}
