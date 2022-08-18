package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee>getAllEmployee();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee,int id);
    void deleteEmployee(int id);

}
