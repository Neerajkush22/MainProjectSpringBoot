package com.SpringBootProject.EmployeeManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "assestDetials")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String furniture;
    @Column
    String gadgets;
    @Column
    String bills;

    @ManyToOne(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Organisation organisation;



}
