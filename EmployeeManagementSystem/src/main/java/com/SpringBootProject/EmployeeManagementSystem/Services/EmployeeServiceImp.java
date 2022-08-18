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
        List<Employee> emp=employeeRepo.findAll();
        boolean isFound=false;
        for(Employee e:emp)
        {
            if (e.getEmail().equals(employee.getEmail()))
            {
                isFound=true;
                break;
            }
        }
        if(isFound)
        {
            return null;
        }
        else
        {
            String encodepass=this.passwordEncoder.encode(employee.getPassword());
            employee.setPassword(encodepass);
            return employeeRepo.save(employee);
        }
    }

    @Override
    public List<Employee> getAllEmployee()
    {
        List<Employee>employees= employeeRepo.findAll();
        for (Employee e:employees)
        {
            e.setPassword("The password is hidden");
        }
        return employees;
    }
    @Override
    public Employee getEmployeeById(int id)
    {
        Employee employee= employeeRepo.findById(id).orElseThrow();
        employee.setPassword("Password is hidden");
        return employee;
    }
    @Override
    public Employee updateEmployee(Employee employee,int id)
    {
        Employee existingDetail= employeeRepo.findById(id).orElseThrow();
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
    public void deleteEmployee(int id)
    {
        employeeRepo.findById(id).orElseThrow();
        employeeRepo.deleteById(id);
    }

}
