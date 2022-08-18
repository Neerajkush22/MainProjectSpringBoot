package com.SpringBootProject.EmployeeManagementSystem.Repository;

import com.SpringBootProject.EmployeeManagementSystem.Models.Assets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetsRepo extends JpaRepository<Assets,Integer> {

    Optional<Assets> findById(int id);
}
