package com.example.springbootonline2.repository;

import com.example.springbootonline2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select o from Employee o where o.firstName = ?1")
    List<Employee> listFirstName(String firstName);

    List<Employee> findByLastName(String lastName);
}
