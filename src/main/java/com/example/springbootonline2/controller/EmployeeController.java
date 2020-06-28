package com.example.springbootonline2.controller;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> listAllEmployee() {
        return employeeRepository.listAll();
    }

    public void createEmployee() {

    }
}
