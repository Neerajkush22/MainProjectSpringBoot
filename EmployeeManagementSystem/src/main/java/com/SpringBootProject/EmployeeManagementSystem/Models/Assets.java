package com.SpringBootProject.EmployeeManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "assestDetials")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    String furniture;
    @Column
    String gadgets;
    @Column
    String bills;
    @Column(nullable = true)
    private int organizationid;



}
