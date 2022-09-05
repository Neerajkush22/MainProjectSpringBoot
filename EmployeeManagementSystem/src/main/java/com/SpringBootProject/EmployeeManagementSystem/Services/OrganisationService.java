package com.SpringBootProject.EmployeeManagementSystem.Services;
import com.SpringBootProject.EmployeeManagementSystem.Models.Organisation;

import java.util.List;

public interface OrganisationService {
    Organisation saveOrganisation(Organisation organisation);
    List<Organisation> getOrganisation();
    Organisation getOrganisationById(int id);
    Organisation updateOrganisation(Organisation organisation,int id);
    void deleteOrganisation(int id);

}
