package com.minjun.wang.enterprise.service.impl;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.minjun.wang.enterprise.model.Employee;
import com.minjun.wang.enterprise.service.EmployeeService;

public class EmployeeServiceImplTest {

    @Test
    public void test() {
	System.out.println("load context");
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	Employee em = new Employee();
	em.setId("3");
	em.setName("John");
	em.setAge(10);
	EmployeeService emService = (EmployeeService) context
		.getBean("employeeService");
	emService.persistEmployee(em);
	System.out.println("Updated age :"
		+ emService.findEmployeeById("3").getAge());
	em.setAge(10);
	emService.updateEmployee(em);
	System.out.println("Updated age :"
		+ emService.findEmployeeById("3").getAge());
	emService.deleteEmployee(em);
	context.close();
    }

}
