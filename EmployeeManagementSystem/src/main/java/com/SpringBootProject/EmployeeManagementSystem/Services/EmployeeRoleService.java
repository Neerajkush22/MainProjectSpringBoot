package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.EmployeeRole;

import java.util.List;

public interface EmployeeRoleService {
    EmployeeRole saveRoleOfEmployee(EmployeeRole roleOfEmployee);

    List<EmployeeRole> getAllRoleOfEmployee();
    EmployeeRole getRoleOfEmployeeById(int id);
    EmployeeRole updateRoleOfEmployee(EmployeeRole roleOfEmployee,int id);
    void deleteRoleOfEmployee(int id);
}
