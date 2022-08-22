package com.SpringBootProject.EmployeeManagementSystem.Controllers;
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
        if (organisation.getOrgAdd().length() > 0 && organisation.getOrgName().length() > 0) {
            Organisation org = organisationService.saveOrganisation(organisation);
            if (org == null) {
                return new ResponseEntity<>("Organisation Already Exist", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<String>("Organisation details added Successfully", HttpStatus.CREATED);
            }
        } else {
            return new ResponseEntity<>("Enter valid email", HttpStatus.BAD_REQUEST);
        }
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

    @GetMapping("/getById/{id}")
    public ResponseEntity<Organisation> getOrganisationById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<Organisation>(organisationService.getOrganisationById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Organisation>(HttpStatus.NOT_FOUND);
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

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteOrganisation(@PathVariable("id") int id) {
        try {

            organisationService.deleteOrganisation(id);
            return new ResponseEntity<String>("Organisation has been deleted", HttpStatus.OK);
        } catch (NoSuchElementException e) {

            return new ResponseEntity<>("Organisation not found",HttpStatus.NOT_FOUND);
        }
    }
}