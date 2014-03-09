package com.minjun.wang.enterprise.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("cutService")
public class CutService {
	
	@Value("#{'aaa'}")
	private String name;
	
	
	public void setName() {
		
	}
	public void printName() {
		System.out.println(name);
	}
	//@Pointcut("execution(public * (..))")
	private void anyPublicOperation() {}
	//@Pointcut("within(com.minjun.wang.enterprise.dao...)")
	private void inTrading() {}
	//@Pointcut("anyPublicOperation() && inTrading()")
	private void tradingOperation() {}
}
