package com.SpringBootProject.EmployeeManagementSystem.Controllers;
import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import com.SpringBootProject.EmployeeManagementSystem.Repository.EmployeeRepo;
import com.SpringBootProject.EmployeeManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }


    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }



    @GetMapping
    public List<Employee>getAllEmployee(){
       return employeeService.getAllEmployee();
    }


    @GetMapping("/login/{id}")
    public ResponseEntity<?>getEmployeeById(@PathVariable("id")int id)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        int userID=employeeRepo.findByEmail(authentication.getName()).get().getId();
        if(userID!=id && authentication.getAuthorities().contains(new SimpleGrantedAuthority("Employee")))
        {
            return new ResponseEntity<String >("Unauthorized Access.",HttpStatus.UNAUTHORIZED);
        }

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
