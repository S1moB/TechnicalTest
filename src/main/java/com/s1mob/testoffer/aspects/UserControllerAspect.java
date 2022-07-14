package com.s1mob.testoffer.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class UserControllerAspect {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.s1mob.testoffer.controller.UserController)")
    public void controller() {
    }
    @Pointcut("execution(* *.*(..))")
    protected void allMethod() {
    }

    @Around("controller() && allMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        try {
            log.info("input of the call " + joinPoint.getSignature());
            Arrays.stream(joinPoint.getArgs()).forEach(arg -> log.info("====>" + arg));
            log.info("Before execution of  " + joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("After execution of  " + joinPoint.getSignature());
            long elapsedTime = System.currentTimeMillis() - start;
            log.info("execution time : " + elapsedTime + " ms");
            log.info("Output of the call : " + result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }
}
