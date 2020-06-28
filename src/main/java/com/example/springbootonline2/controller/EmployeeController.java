package com.example.springbootonline2.controller;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> listAllEmployee() {
        return employeeRepository.listAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id);
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
    }
}
