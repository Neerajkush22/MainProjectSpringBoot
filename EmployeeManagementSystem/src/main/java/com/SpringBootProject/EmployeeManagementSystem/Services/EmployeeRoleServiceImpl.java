package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.EmployeeRole;
import com.SpringBootProject.EmployeeManagementSystem.Repository.EmployeeRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleRepo employeeRoleRepo;

    public EmployeeRoleServiceImpl(EmployeeRoleRepo employeeRoleRepo) {
        this.employeeRoleRepo = employeeRoleRepo;
    }

    @Override
    public EmployeeRole saveRoleOfEmployee(EmployeeRole roleOfEmployee) {
        return employeeRoleRepo.save(roleOfEmployee);
    }

    @Override
    public List<EmployeeRole> getAllRoleOfEmployee() {
        return employeeRoleRepo.findAll();
    }

    @Override
    public EmployeeRole getRoleOfEmployeeById(int id) {
        return employeeRoleRepo.findById(id).orElseThrow();    }

    @Override
    public EmployeeRole updateRoleOfEmployee(EmployeeRole roleOfEmployee, int id) {
        EmployeeRole existingDetail = employeeRoleRepo.findById(id).orElseThrow();
        existingDetail.setEmployeeid(roleOfEmployee.getEmployeeid());
        existingDetail.setRoleid(roleOfEmployee.getRoleid());
        employeeRoleRepo.save(existingDetail);
        return existingDetail;
    }

    @Override
    public void deleteRoleOfEmployee(int id) {
        employeeRoleRepo.findById(id).orElseThrow();
        employeeRoleRepo.deleteById(id);

    }
}