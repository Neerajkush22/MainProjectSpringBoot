package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;


import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    List<Employee>getAllEmployee();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee,int id);
    public boolean deleteEmployee(int id);

}
