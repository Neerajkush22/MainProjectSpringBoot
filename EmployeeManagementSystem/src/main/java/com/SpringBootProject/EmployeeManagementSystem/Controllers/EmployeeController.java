package com.SpringBootProject.EmployeeManagementSystem.Controllers;
import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import com.SpringBootProject.EmployeeManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }


    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
    {
        if(employee.getPassword().length()>6&&employee.getAddress().length()>0&&employee.getEmpFName().length()>0&&employee.getEmpLName().length()>0&&employee.getEmail().length()>0&&!employee.getPassword().contains("-")&&employee.getDomain().length()>0&&employee.getExp()>0&&employee.getSalary()>0) {
            Employee emp = employeeService.saveEmployee(employee);
            if (emp == null) {
                return new ResponseEntity<>("Employee Already Exist", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<String>("Employee's details added Successfully", HttpStatus.CREATED);
            }
        }
        else
        {
            return new ResponseEntity<>("Please enter valid data",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity< List<Employee>> getAllEmployee(){
        List<Employee> employee =employeeService.getAllEmployee();
        if(employee.size()>0){
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/login/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")int id)
    {
       try {
           return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
       }
       catch (NoSuchElementException e)
       {
           return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id")int id, @RequestBody Employee employee)
    {
        try {
            if(employee.getPassword().length()>6&&employee.getAddress().length()>0&&employee.getEmpFName().length()>0&&employee.getEmpLName().length()>0&&employee.getEmail().length()>0&&!employee.getPassword().contains("-")&&employee.getDomain().length()>0&&employee.getExp()>0&&employee.getSalary()>0) {
                employeeService.updateEmployee(employee, id);
                return new ResponseEntity<String>("Employee's details updated Successfully", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<String>("Enter valid details",HttpStatus.BAD_REQUEST);
            }
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("Employee's details not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id")int id)
    {
        try {

            employeeService.deleteEmployee(id);
            return new ResponseEntity<String>("Employee has been deleted",HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("Employee is not found",HttpStatus.NOT_FOUND);
        }
    }
}
