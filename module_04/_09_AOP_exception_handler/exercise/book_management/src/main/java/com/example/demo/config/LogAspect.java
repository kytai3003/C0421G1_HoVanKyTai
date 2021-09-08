package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class LogAspect {
    private int count = 0;

    @Pointcut("within(com.example.demo.controllers.BookController*)")
    public void allMethodPointcut() {
    }

    @Around("allMethodPointcut()")
    public Object aroundCallMethod(ProceedingJoinPoint proceedingJoinPoint) {
        System.err.println("Starting method at: " + LocalDate.now());
        Object value = null;


        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.err.println("Throwing exception at: " + LocalDate.now());
            throwable.printStackTrace();
        }

        System.err.println("Finishing method at: " + LocalDate.now() + " Return: " + value);
        return value;
    }
    
    @Before("allMethodPointcut()")
    public void countTheVisitor() {
        System.err.println("+1 visitor. Total: " + ++count);
    }
}
