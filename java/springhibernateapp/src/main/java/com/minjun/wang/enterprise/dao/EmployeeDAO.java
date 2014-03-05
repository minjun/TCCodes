package com.minjun.wang.enterprise.dao;

import com.minjun.wang.enterprise.model.Employee;

public interface EmployeeDAO {
    public void persistEmployee(Employee employee);
    public Employee findEmployeeById(String id);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
