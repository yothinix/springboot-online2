package com.example.springbootonline2.repository;

import com.example.springbootonline2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByLastName(String lastName);
    List<Employee> findByFirstName(String firstName);
}
