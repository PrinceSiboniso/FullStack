package com.java.java_full_stack.service;


import com.java.java_full_stack.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee updateEmployee(Employee employee, Long id);
    Employee getEmployeeId(Long id);

    void deleteEmployee(Long id);


}
