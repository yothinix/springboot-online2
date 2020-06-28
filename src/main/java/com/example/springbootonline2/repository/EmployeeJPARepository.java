package com.example.springbootonline2.repository;

import com.example.springbootonline2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {
}
