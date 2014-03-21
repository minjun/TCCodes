package com.minjun.wang.enterprise.service.impl;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minjun.wang.enterprise.dao.EmployeeDAO;
import com.minjun.wang.enterprise.model.Employee;
import com.minjun.wang.enterprise.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
	@Autowired
	private UserMapper userMapper;

    @Override
    @Transactional
    public void persistEmployee(Employee employee) {
	// TODO Auto-generated method stub
	employeeDAO.persistEmployee(employee);
    }

    @Override
    @Transactional
    public Employee findEmployeeById(String id) {
	// TODO Auto-generated method stub
	//return employeeDAO.findEmployeeById(id);
		return this.userMapper.getUser(userId);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
	employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
	// TODO Auto-generated method stub
	employeeDAO.deleteEmployee(employee);
    }
	
	

}
