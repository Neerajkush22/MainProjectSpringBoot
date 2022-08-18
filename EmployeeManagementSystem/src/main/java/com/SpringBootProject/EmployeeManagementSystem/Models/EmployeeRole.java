package com.SpringBootProject.EmployeeManagementSystem.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EmployeeRole")
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int employeeid;
    @Column(nullable = false)
    private int roleid;


}
