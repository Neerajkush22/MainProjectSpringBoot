package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmployeeService {
    public boolean saveEmployee(Employee employee);
    List<Employee>getAllEmployee();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee,int id);
    public boolean deleteEmployee(int id);

}
