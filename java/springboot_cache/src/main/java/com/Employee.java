package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


@Component
public class Employee {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Cacheable(value="default", key = "#id")
	public String getEmployee(Integer id){
		logger.info("get employee called for id:"+id);
		return "employee"+id;
	}

}