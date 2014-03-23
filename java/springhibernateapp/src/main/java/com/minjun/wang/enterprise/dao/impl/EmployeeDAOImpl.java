package com.minjun.wang.enterprise.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Set;

import com.minjun.wang.enterprise.dao.EmployeeDAO;
import com.minjun.wang.enterprise.model.*;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
    //@Autowired
    SessionFactory sessionFactory;

    @Override
    public void persistEmployee(Employee employee) {
	// TODO Auto-generated method stub
	Set<Passport> pts = employee.getPassport();
	for (Passport pt:pts) {
		sessionFactory.getCurrentSession().persist(pt);
	}
	sessionFactory.getCurrentSession().persist(employee);
    }

    @Override
    public Employee findEmployeeById(String id) {
	// TODO Auto-generated method stub
	return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().update(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().delete(employee);
    }

}
