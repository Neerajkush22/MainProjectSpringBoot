package com.SpringBootProject.EmployeeManagementSystem.Repository;

import com.SpringBootProject.EmployeeManagementSystem.Models.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganisationRepo extends JpaRepository<Organisation,Integer> {

    Optional<Organisation> findById(int id);
}
