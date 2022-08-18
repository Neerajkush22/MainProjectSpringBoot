package com.SpringBootProject.EmployeeManagementSystem.Controllers;

import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import com.SpringBootProject.EmployeeManagementSystem.Models.Organisation;
import com.SpringBootProject.EmployeeManagementSystem.Services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Organisation")
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping
    public ResponseEntity<String> saveOrganisation(@RequestBody Organisation organisation) {
        organisationService.saveOrganisation(organisation);
        return new ResponseEntity<String>("Organisation is added successful", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Organisation>> getOrganisation() {
        List<Organisation> organisation = organisationService.getOrganisation();
        if (organisation.size() > 0) {
            return new ResponseEntity<>(organisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateOrganisation(@PathVariable("id") int id, @RequestBody Organisation organisation) {
        try {

            organisationService.updateOrganisation(organisation, id);
            return new ResponseEntity<String>("Organisation's details updated Successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {

            return new ResponseEntity<String>("Organisation's details not found", HttpStatus.NOT_FOUND);
        }
    }
}