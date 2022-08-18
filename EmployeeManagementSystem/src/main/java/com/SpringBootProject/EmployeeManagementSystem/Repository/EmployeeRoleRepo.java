package com.SpringBootProject.EmployeeManagementSystem.Repository;

import com.SpringBootProject.EmployeeManagementSystem.Models.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRoleRepo extends JpaRepository<EmployeeRole,Integer> {
    Optional<EmployeeRole> findById(int id);
}
