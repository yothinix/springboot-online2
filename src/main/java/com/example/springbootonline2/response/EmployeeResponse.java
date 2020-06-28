package com.example.springbootonline2.response;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Entity
public class EmployeeResponse {
    @Id
    @Column(name = "ID") private Integer id;
    @Column(name = "FIRST_NAME") private String firstName;
    @Column(name = "LAST_NAME") private String lastName;
    @Column(name = "DEPARTMENT") private String department;

    @Transient
    private Integer money;
}
