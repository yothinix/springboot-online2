package com.example.springbootonline2.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {
    @Id
    @Column(name = "ID") private Integer id;
    @Column(name = "FIRST_NAME") private String firstName;
    @Column(name = "LAST_NAME") private String lastName;
}
