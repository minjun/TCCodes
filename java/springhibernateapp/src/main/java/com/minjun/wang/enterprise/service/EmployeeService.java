package com.minjun.wang.enterprise.service;

import com.minjun.wang.enterprise.model.Employee;

public interface EmployeeService {

    void persistEmployee(Employee employee);

    Employee findEmployeeById(String id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
