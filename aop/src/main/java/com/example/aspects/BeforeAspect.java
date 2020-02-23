package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author meettpatel
 * @date 2020-02-23
 */
@Component
@Aspect
public class BeforeAspect {

    @Before("execution(public * com.example..*(..))")
    public void beforeEnterMethod(JoinPoint joinPoint) {
        System.out.println("Before Call Method -> "+ joinPoint.getStaticPart().getSignature().toString());
    }

    @After("execution(public * com.example..*(..))")
    public void afterEndMethod(JoinPoint joinPoint) {
        System.out.println("After End Method -> "+ joinPoint.getSignature().toString());
    }
    @AfterThrowing(value = "execution(public * com.example..*(..))", throwing = "ex")
    public void afterMethodThrowError(JoinPoint joinPoint, RuntimeException ex) {
        System.out.println(ex + " in method -> " + joinPoint.getSignature().toString());
    }

    @AfterReturning(pointcut = "execution(public String com.example..*(..))", returning = "returnValue",)
    public void afterMethodReturnString(String returnValue) {
        System.out.println("Return Value of Method ->  = "+ returnValue);
    }
}
