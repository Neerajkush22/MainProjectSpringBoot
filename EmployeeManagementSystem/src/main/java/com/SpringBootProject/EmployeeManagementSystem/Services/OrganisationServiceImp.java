package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.Organisation;
import com.SpringBootProject.EmployeeManagementSystem.Repository.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationServiceImp implements OrganisationService{
    @Autowired
    private OrganisationRepo organisationRepo;
    public OrganisationServiceImp(OrganisationRepo organisationRepo) {
        this.organisationRepo = organisationRepo;
    }
    @Override
    public Organisation saveOrganisation(Organisation organisation)
    {
        return this.organisationRepo.save(organisation);
    }
    @Override
    public List<Organisation> getOrganisation()
    {
        return organisationRepo.findAll();
    }
    @Override
    public Organisation getOrganisationById(int id)
    {
        return organisationRepo.findById(id).orElseThrow();
    }
    @Override
    public Organisation updateOrganisation(Organisation organisation,int id)
    {
        Organisation existingOrganisation = organisationRepo.findById(id).orElseThrow();
        existingOrganisation.setOrgName(organisation.getOrgName());
        existingOrganisation.setOrgAdd(organisation.getOrgAdd());
        organisationRepo.save(existingOrganisation);
        return existingOrganisation;
    }
    @Override
    public void deleteOrganisation(int id)
    {
        organisationRepo.findById(id).orElseThrow();
        organisationRepo.deleteById(id);
    }

}
