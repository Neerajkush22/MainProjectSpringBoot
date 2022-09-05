package com.SpringBootProject.EmployeeManagementSystem.Controllers;
import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import com.SpringBootProject.EmployeeManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<String> saveEmployee(@RequestBody @Valid Employee employee) {
        return new ResponseEntity<String>("Employee Added Successfully",HttpStatus.CREATED);
    }



    @GetMapping
    public List<Employee>getAllEmployee(){
       return employeeService.getAllEmployee();
    }


    @GetMapping("/login/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id")int id, @RequestBody @Valid Employee employee)
    {
        employeeService.updateEmployee(employee,id);
        return new ResponseEntity<String>("Employee Updated Successful",HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id")int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
}
