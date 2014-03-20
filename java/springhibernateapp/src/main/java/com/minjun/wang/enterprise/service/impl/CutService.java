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
}
