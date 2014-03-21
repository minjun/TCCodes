package com.minjun.wang.enterprise.service.impl;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.minjun.wang.enterprise.model.*;
import com.minjun.wang.enterprise.service.EmployeeService;

public class EmployeeServiceImplTest {

    //@Test
    public void testHibernate() {
	System.out.println("load context");
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	
	Passport ppt = new Passport();
	ppt.setId("3");
	ppt.setName("test");
	Employee em = new Employee();
	em.setId("3");
	em.setName("John");
	em.setAge(10);
	em.addPassport(ppt);
	EmployeeService emService = (EmployeeService) context
		.getBean("employeeService");
	emService.persistEmployee(em);
	System.out.println("Updated age :"
		+ emService.findEmployeeById("3").getAge());
	em.setAge(11);
	emService.updateEmployee(em);
	System.out.println("Updated age :"
		+ emService.findEmployeeById("3").getAge());
	emService.deleteEmployee(em);
	/*
	CutService cutService = (CutService)context.getBean("cutService1");
	cutService.printName();
	context.close();
	*/
    }
	@Test
	public void testMyBatis() {
	

}
