package com.SpringBootProject.EmployeeManagementSystem.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int employeeid;
    @Column
    private int roleid;


}
