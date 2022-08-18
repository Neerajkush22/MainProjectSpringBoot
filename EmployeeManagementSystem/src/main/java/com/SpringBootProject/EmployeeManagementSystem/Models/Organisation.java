package com.SpringBootProject.EmployeeManagementSystem.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "organisationDetails")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String orgName;
    String orgAdd;

}
