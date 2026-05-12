package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.demo.OrderService.*(..))")
    public void logBefore(JoinPoint jp) {
        System.out.println(">> Before : " + jp.getSignature().getName());
    }

    @After("execution(* com.example.demo.OrderService.*(..))")
    public void logAfter(JoinPoint jp) {
        System.out.println("<< After : " + jp.getSignature().getName());
    }
}