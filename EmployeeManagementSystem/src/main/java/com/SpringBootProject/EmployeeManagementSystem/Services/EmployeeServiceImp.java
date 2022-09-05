package com.SpringBootProject.EmployeeManagementSystem.Services;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import com.SpringBootProject.EmployeeManagementSystem.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    PasswordEncoder passwordEncoder;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.passwordEncoder=new BCryptPasswordEncoder();
        this.employeeRepo = employeeRepo;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        String encodepass=this.passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodepass);
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee()
    {
        List<Employee>emp= employeeRepo.findAll();
        for (Employee e:emp)
        {
            e.setPassword("THIS INFORMATION CANNOT BE LEAKED");
        }
        return emp;
    }
    @Override
    public Employee getEmployeeById(int id)
    {
        Employee employee= employeeRepo.findById(id).orElseThrow(()-> new com.SpringBootProject.EmployeeManagementSystem.Exception.ResourceNotFoundException("Employee not found by id"+id));
        return employee;
    }
    @Override
    public Employee updateEmployee(Employee employee,int id)
    {
        Employee existingDetail= employeeRepo.findById(id).orElseThrow(()-> new com.SpringBootProject.EmployeeManagementSystem.Exception.ResourceNotFoundException("Employee not found with id :" + id));
        String encodepass=this.passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodepass);

        existingDetail.setAddress(employee.getAddress());
        existingDetail.setDomain(employee.getDomain());
        existingDetail.setExp(employee.getExp());
        existingDetail.setEmpFName(employee.getEmpFName());
        existingDetail.setEmpLName(employee.getEmpLName());
        existingDetail.setSalary(employee.getSalary());
        employeeRepo.save(existingDetail);
        return existingDetail;
    }
    @Override
    public boolean deleteEmployee(int id)
    {
        try
        {
            Employee emp=employeeRepo.findById(id).orElseThrow();
            employeeRepo.deleteById(emp.getId());
            return true;
        }
        catch (NullPointerException e)
        {
            return false;
        }
}

}
