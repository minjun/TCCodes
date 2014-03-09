package com.minjun.wang.enterprise.service.impl;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component("welcomeAdvice")
public class WelcomeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object obj)
            throws Throwable {
        
        System.out.println("Hello welcome to bye ");

    }

}