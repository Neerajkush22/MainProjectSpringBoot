package com.SpringBootProject.EmployeeManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;


@Data
@Entity
@Table(name = "organisationDetails")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String orgName;
    String orgAdd;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval=true ,fetch = FetchType.EAGER)
    private Set<Employee> Employee=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval=true ,fetch = FetchType.EAGER)
    private Set<Assets> Assets =new HashSet<>();
}
